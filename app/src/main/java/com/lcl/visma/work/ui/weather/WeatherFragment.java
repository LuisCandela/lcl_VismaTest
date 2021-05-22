package com.lcl.visma.work.ui.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lcl.visma.work.R;
import com.lcl.visma.work.databinding.WeatherFragmentBinding;

import org.jetbrains.annotations.NotNull;

public class WeatherFragment extends Fragment {

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

        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        // set the context app to use of services
        mViewModel.setContext(getContext());
        // pass the private variable to the xml view
        weatherFragmentBinding.setWeatherViewModel(mViewModel);

    }

}