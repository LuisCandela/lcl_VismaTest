package com.lcl.visma.work.ui.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lcl.visma.work.R;
import com.lcl.visma.work.databinding.WeatherFragmentBinding;
import com.lcl.visma.work.model.InfoAdapter;
import com.lcl.visma.work.services.eltiempo.api.response.Provincia;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WeatherFragment extends Fragment implements View.OnClickListener, AdapterViewBindingAdapter.OnItemSelected, AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private TextView weatherInfo;

    private WeatherViewModel mViewModel;
    // generated when changed from constraintLayout to Layout on login_fragmnet
    private WeatherFragmentBinding weatherFragmentBinding;

    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        weatherFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.weather_fragment, container, false);

        final View view = weatherFragmentBinding.getRoot();

        initComponents(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        // set the context app to use of services
        mViewModel.initViewModel(getContext());
        // pass the private variable to the xml view
        weatherFragmentBinding.setWeatherViewModel(mViewModel);

        initView();

    }

    /**
     * method to get all the components from the view and initialize them.
     *
     * @param view View
     */
    private void initComponents(final View view) {
        view.findViewById(R.id.weather_fragmet_singout_btn).setOnClickListener(this);
        spinner = view.findViewById(R.id.weather_fragment_provincias_spinner);
        spinner.setOnItemSelectedListener(this);
        weatherInfo = view.findViewById(R.id.weather_fragment_weather_info);
        spinnerLoading();
    }

    /**
     * show loading mesage on spinner dropdown while retrieving the data
     */
    private void spinnerLoading() {
        List<InfoAdapter> emptyAdapter = new ArrayList<InfoAdapter>();
        emptyAdapter.add(new InfoAdapter("-1", getString(R.string.weather_spinner_loading)));
        fillProvinciasSpinner(emptyAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.weather_fragmet_singout_btn) {
            // logOut from google
            mViewModel.logOut();
            // close weather view, go to logIn
            goToLogIn();
        }
    }

    /**
     * methods thrown when the view is already created
     */
    private void initView() {
        // use an observe so the view can still being
        // loaded and it doesnt have to wait to recive this data (MutableLiveData)
        mViewModel.getProvincias().observe(getViewLifecycleOwner(), provincias -> {
            List<InfoAdapter> provinciasAdapter = new ArrayList<InfoAdapter>() {
            };

            for (Provincia provincia : provincias) {
                provinciasAdapter.add(new InfoAdapter(provincia.getCod(), provincia.getNombre()));
            }
            provinciasAdapter.add(0, new InfoAdapter("-1", getString(R.string.weather_spinner_default)));
            fillProvinciasSpinner(provinciasAdapter);
        });


    }

    /**
     * method to fill the list of Provicias dropDown
     *
     * @param info List
     */
    private void fillProvinciasSpinner(List<InfoAdapter> info) {
        ArrayAdapter spinnerAdapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_spinner_item, info);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
    }

    /**
     * navigation to Login activity
     */
    private void goToLogIn() {
        // TODO: change navigation to https://developer.android.com/guide/navigation/navigation-navigate ¿change to common method on baseViewModel?
        getActivity().finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // we have the id of the province as it is stored on the infoAdapter object used on the dropDown
        InfoAdapter selected = (InfoAdapter) parent.getItemAtPosition(position);
        if (!selected.getId().equals("-1")) {
            mViewModel.getWeatherInfo(selected.getId()).observe(this, provincia -> {
                // TODO: change to mutablelivedata from ViewModel
                if (provincia != null) {
                    weatherInfo.setText(provincia.getToday().getInformacion());
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}