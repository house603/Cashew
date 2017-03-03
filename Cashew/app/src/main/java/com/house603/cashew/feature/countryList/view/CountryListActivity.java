package com.house603.cashew.feature.countryList.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.house603.cashew.R;
import com.house603.cashew.base.BaseActionbarActivity;
import com.house603.cashew.base.presenter.Presenter;
import com.house603.cashew.di.component.DaggerProjectComponent;
import com.house603.cashew.di.module.ProjectModule;
import com.house603.cashew.feature.countryList.adapter.CountryListAdapter;
import com.house603.cashew.feature.countryList.adapter.CountryListAdapterListener;
import com.house603.cashew.feature.countryList.presenter.view.CountryListPresenter;
import com.house603.cashew.feature.countryList.presenter.view.CountryListView;
import com.house603.cashew.model.CurrencyModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.R.id.message;
import static com.house603.cashew.R.id.textView1;

public class CountryListActivity extends BaseActionbarActivity implements CountryListView {
    @Inject
    CountryListPresenter mPresenter;
    private RecyclerView mRecyclerView;
    CurrencyModel mCurrencymodel;

    String[] countryNames = new String[]{
            "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
            "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "The Bahamas",
            "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda",
            "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "British Virgin Islands",
            "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
            "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands",
            "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Côte d'Ivoire", "Croatia", "Cuba",
            "Cyprus", "Czech Republic", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
            "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Faeroe Islands",
            "Falkland Islands", "Fiji", "Finland", "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
            "Gabon", "The Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland",
            "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
            "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq",
            "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya",
            "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia",
            "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Madagascar", "Malawi", "Malaysia",
            "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte",
            "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique",
            "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
            "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
            "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay",
            "Peru", "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
            "Réunion", "Romania", "Russia", "Rwanda", "Saint Helena", "Saint Kitts and Nevis", "Saint Lucia",
            "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "São Tomé and Príncipe", "Saudi Arabia", "Senegal",
            "Serbia and Montenegro", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia",
            "South Africa", "South Georgia and the South Sandwich Islands", "South Korea", "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen",
            "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand",
            "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
            "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay",
            "US Virgin Islands", "Uzbekistan", "Vanuatu", "The Hoy See (Vatican City State)", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
            "Yemen", "Zambia", "Zimbabwe"

    };
    int[] flagId = new int[]{
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
//            R.mipmap.flag_india, R.drawable.flag_australia, R.drawable.flag_china, R.drawable.flag_indonesia,
//            R.drawable.flag_japan, R.drawable.flag_newzealand, R.drawable.flag_russia, R.drawable.flag_southkorea
    };
    String[] capital = new String[]{
            "Kabul", "Tirana", "Algiers", "Pago Pago", "Andorra la Vella", "Luanda", "The Valley",
            "St John's", "Buenos Aires", "Yerevan", "Oranjestad", "Canberra", "Vienna", "Baku", "Nassau",
            "Manama", "Dhaka", "Bridgetown", "Minsk", "Brussels", "Belmopan", "Porto Novo", "Hamilton",
            "Thimphu", "Sucre", "Sarajevo", "Gaborone", "Brasilia", "Road Town",
            "Bandar Seri Begawan", "Sofia", "Ouagadougou", "Bujumbura", "Phnom Penh", "Yaoundé", "Ottawa", "Praia",
            "George Town", "Bangui", "N'Djamena", "Santiago", "Beijing", "Flying Fish Cove", "Bantam",
            "Santa Fe de Bogotá", "Moroni", "Brazzaville", "Avarua", "San José", "Yamoussoukro", "Zagreb", "Havana",
            "Nicosia", "Prague", "Kinshasa", "Copenhagen", "Djibouti", "Roseau", "Santo Domingo",
            "Quito", "Cairo", "San Salvador", "Malabo", "Asmara", "Tallinn", "Addis Ababa", "Thorshavn",
            "Stanley", "Suva", "Helsinki", "Skopje", "Paris", "Cayenne", "Papeete",
            "Libreville", "Banjul", "Tbilisi", "Berlin", "Accra", "Gibraltar", "Athens", "Nuuk",
            "St George's", "Basse Terre", "Hagåtña", "Guatemala City", "Conakry", "Bissau", "Georgetown", "Port-au-Prince",
            "Tegucigalpa", "Hong Kong", "Budapest", "Reykjavik", "New Delhi", "Jakarta", "Tehran", "Baghdad",
            "Dublin", "Israel", "Rome", "Kingston", "Tokyo", "Amman", "Astana", "Nairobi",
            "Tarawa", "Kuwait City", "Bishkek", "Vientiane", "Riga", "Beirut", "Lesotho", "Monrovia",
            "Tripoli", "Vaduz", "Vilnius", "Luxembourg", "Macau", "Antananarivo", "Lilongwe", "Kuala Lumpur",
            "Malé", "Bamako", "Valletta", "Majuro", "Fort-de-France", "Nouakchott", "Port Louis", "Mamoudzou",
            "Mexico City", "Palikir", "Chisinau", "Monaco", "Ulan Bator", "Plymouth", "Rabat", "Maputo",
            "Yangon", "Windhoek", "Yaren", "Kathmandu", "Amsterdam", "Willemstad", "Nouméa", "Wellington",
            "Managua", "Niamey", "Abuja", "Alofi", "Kingston", "Pyongyang", "Garapan",
            "Oslo", "Muscat", "Islamabad", "Koror", "Panama City", "Port Moresby", "Asunción",
            "Lima", "Manila", "Adamstown", "Warsaw", "Lisbon", "San Juan", "Doha",
            "Saint-Denis", "Bucharest", "Moscow", "Kigali", "Jamestown", "Basseterre", "Castries",
            "Saint-Pierre", "Kingstown", "Apia", "San Marino", "São Tomé", "Riyadh", "Dakar",
            "Belgrade", "Victoria", "Freetown", "Singapore", "Bratislava", "Ljubljana", "Honiara", "Mogadishu",
            "Pretoria", "Seoul", "Madrid", "Colombo", "Khartoum", "Paramaribo", "Longyearbyen",
            "Mbabane", "Stockholm", "Berne", "Damascus", "Taipei", "Dushanbe", "Dodoma", "Bangkok",
            "Dili", "Lomé", "Fakaofo", "Nuku'alofa", "Port of Spain", "Tunis", "Ankara", "Ashgabat",
            "Cockburn Town", "Fongafale", "Kampala", "Kiev", "Abu Dhabi", "London", "Washington DC", "Montevideo",
            "Charlotte Amalie", "Tashkent", "Port Vila", "Vatican City", "Caracas", "Hanoi", "Mata-Utu", "Al aaiun",
            "San'a", "Lusaka", "Harare"
    };

    String[] currency = new String[]{
            "Rupee", "Dollar", "Renminbi", "Rupiah",
            "Yen", "Dollar", "Ruble", "Won"
    };
    private LinearLayoutManager mLayoutManager;
    CountryListAdapter mAdapter;
    private List<CurrencyModel>mCountryList;
    private int id_flag1;
    int id;

    @Override
    public void initView() {
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rec_country);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    @Override
    public void initModel() {

    }

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        initView();
        injectInjector();
    }


    @Override
    protected void injectInjector() {
        DaggerProjectComponent.builder().projectModule(new ProjectModule(this)).build().inject(this);
        mPresenter.setView(this);
        Intent intent = getIntent();
        if (intent.getStringExtra("flag1") != null) {
            id_flag1 = intent.getIntExtra("id", 0);
            if (intent.getStringExtra("flag1").equals("flag1Country")) {
                id_flag1 = id;

            }
        } else if (intent.getStringExtra("flag2") != null) {
                id_flag1 = intent.getIntExtra("id", 0);

            if (intent.getStringExtra("flag2").equals("flag2Country")) {
                id_flag1 = id;

            }

            }
        mCountryList = new ArrayList<>();
        for (int i = 0; i < countryNames.length; i++) {
            CurrencyModel country = new CurrencyModel();
            country.setmCountryName(countryNames[i]);
            country.setFlag(flagId[i]);
            country.setmCurrencyiso(currency[i]);
            mCountryList.add(country);

            for(CurrencyModel model : mCountryList){
                setCurrencyModel(model);
            }

            mAdapter = new CountryListAdapter(getContext(), mCountryList, new CountryListAdapterListener() {
                @Override
                public void ItemClick(CurrencyModel model, int p) {
                    if (id==5){
                        Intent intent=new Intent();
                        intent.putExtra("map",model.getFlag());
                        intent.putExtra("name", model.getmCountryName());
                        intent.putExtra("iso", model.getmCurrencyiso());
                        setResult(2,intent);
                        finish();
                    }else{
                        Intent intent=new Intent();
                        intent.putExtra("map",model.getFlag());
                        intent.putExtra("name", model.getmCountryName());
                        intent.putExtra("iso", model.getmCurrencyiso());
                        setResult(3,intent);
                        finish();
                    }


                }


        });
            mRecyclerView.setAdapter(mAdapter);


        }
    }


    @Override
    public void showLineLoading() {

    }

    @Override
    public void hideLineLoading() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setCurrencyModel(CurrencyModel model) {
        this.mCurrencymodel = model;

    }
}
