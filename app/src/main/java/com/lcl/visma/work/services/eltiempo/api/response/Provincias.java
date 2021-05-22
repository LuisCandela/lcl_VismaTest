package com.lcl.visma.work.services.eltiempo.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Provincias {
        @SerializedName("title")
        private String title;
        @SerializedName("provincias")
        private List<Provincia> provincias;

        public String getTitle() {
                return title;
        }

        public List<Provincia> getProvincias() {
                return provincias;
        }

        @Override
        public String toString() {
                return "Provincias{" +
                        "title='" + title + '\'' +
                        ", provincias=" + provincias +
                        '}';
        }
}
