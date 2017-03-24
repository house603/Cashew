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
            R.mipmap.afghanistan, R.mipmap.albania, R.mipmap.algeria, R.mipmap.american Samoa, R.mipmap.andorra, R.mipmap.angola, R.mipmap.anguilla,
            R.mipmap.antigua and Barbuda, R.mipmap.argentina, R.mipmap.armenia, R.mipmap.aruba, R.mipmap.australia, R.mipmap.austria, R.mipmap.azerbaijan, R.mipmap.bahamas,
            R.mipmap.bahrain, R.mipmap.bangladesh, R.mipmap.barbados, R.mipmap.belarus, R.mipmap.belgium, R.mipmap.belize, R.mipmap.benin, R.mipmap.bermuda,
            R.mipmap.bhutan, R.mipmap.bolivia, R.mipmap.bosnia, R.mipmap.botswana, R.mipmap.brazil, R.mipmap.british_virgin_islands,
            R.mipmap.brunei, R.mipmap.bulgaria, R.mipmap.burkina_faso, R.mipmap.burundi, R.mipmap.cambodia, R.mipmap.cameroon, R.mipmap.canada, R.mipmap.cape_verde,
            R.mipmap.cayman_islands, R.mipmap.central_african_republic, R.mipmap.chad, R.mipmap.chile, R.mipmap.china, R.mipmap.christmas_island, R.mipmap.cocos_islands,
            R.mipmap.colombia, R.mipmap.comoros, R.mipmap.congo, R.mipmap.cook_islands, R.mipmap.costa_rica, R.mipmap.côte d'ivoire, R.mipmap.croatia, R.mipmap.cuba,
            R.mipmap.cyprus, R.mipmap.czech_republic, R.mipmap.democratic_republic_congo, R.mipmap.denmark, R.mipmap.djibouti, R.mipmap.dominica, R.mipmap.dominican_republic,
            R.mipmap.ecuador, R.mipmap.egypt, R.mipmap.el_salvador, R.mipmap.equatorial_guinea, R.mipmap.eritrea, R.mipmap.estonia, R.mipmap.ethiopia, R.mipmap.faeroe_islands,
            R.mipmap.falkland_islands, R.mipmap.fiji, R.mipmap.finland, R.mipmap.france, R.mipmap.french_guiana, R.mipmap.french_polynesia,
            R.mipmap.gabon, R.mipmap.gambia, R.mipmap.georgia, R.mipmap.germany, R.mipmap.ghana, R.mipmap.gibraltar, R.mipmap.greece, R.mipmap.greenland,
            R.mipmap.grenada, R.mipmap.guadeloupe, R.mipmap.guam, R.mipmap.guatemala, R.mipmap.guinea, R.mipmap.guinea_bissau, R.mipmap.guyana, R.mipmap.haiti,
            R.mipmap.honduras, R.mipmap.hong_kong, R.mipmap.hungary, R.mipmap.iceland, R.mipmap.india, R.mipmap.indonesia, R.mipmap.iran, R.mipmap.iraq,
            R.mipmap.ireland, R.mipmap.israel, R.mipmap.italy, R.mipmap.jamaica, R.mipmap.japan, R.mipmap.jordan, R.mipmap.kazakhstan, R.mipmap.kenya,
            R.mipmap.kiribati, R.mipmap.kuwait, R.mipmap.kyrgyzstan, R.mipmap.laos, R.mipmap.latvia, R.mipmap.lebanon, R.mipmap.lesotho, R.mipmap.liberia,
            R.mipmap.libya, R.mipmap.liechtenstein, R.mipmap.lithuania, R.mipmap.luxembourg, R.mipmap.macau, R.mipmap.madagascar, R.mipmap.malawi, R.mipmap.malaysia,
            R.mipmap.maldives, R.mipmap.mali, R.mipmap.malta, R.mipmap.marshall_islands, R.mipmap.martinique, R.mipmap.mauritania, R.mipmap.mauritius, R.mipmap.mayotte,
            R.mipmap.mexico, R.mipmap.micronesia, R.mipmap.moldova, R.mipmap.monaco, R.mipmap.mongolia, R.mipmap.montserrat, R.mipmap.morocco, R.mipmap.mozambique,
            R.mipmap.myanmar, R.mipmap.mamibia, R.mipmap.nauru, R.mipmap.nepal, R.mipmap.netherlands, R.mipmap.netherlands_antilles, R.mipmap.new_caledonia, R.mipmap.new_zealand,
            R.mipmap.nicaragua, R.mipmap.niger, R.mipmap.nigeria, R.mipmap.niue, R.mipmap.norfolk_island, R.mipmap.north_korea, R.mipmap.northern_marianas,
            R.mipmap.norway, R.mipmap.oman, R.mipmap.pakistan, R.mipmap.palau, R.mipmap.panama, R.mipmap.papua_new_guinea, R.mipmap.paraguay,
            R.mipmap.peru, R.mipmap.philippines, R.mipmap.pitcairn_islands, R.mipmap.poland, R.mipmap.portugal, R.mipmap.puerto_rico, R.mipmap.qatar,
            R.mipmap.réunion, R.mipmap.romania, R.mipmap.russia, R.mipmap.rwanda, R.mipmap.saint_helena, R.mipmap.saint_kitts_and_nevis, R.mipmap.saint_lucia,
            R.mipmap.saint_pierre_and_miquelon, R.mipmap.saint_vincent_and_the_grenadines, R.mipmap.samoa, R.mipmap.san_marino, R.mipmap.são_tomé_and_príncipe, R.mipmap.saudi_arabia, R.mipmap.senegal,
            R.mipmap.serbia_and_montenegro, R.mipmap.seychelles, R.mipmap.sierra_leone, R.mipmap.singapore, R.mipmap.slovakia, R.mipmap.slovenia, R.mipmap.solomon_islands, R.mipmap.somalia,
            R.mipmap.south_africa, R.mipmap.south_georgia, R.mipmap.south_korea, R.mipmap.spain, R.mipmap.sri_lanka, R.mipmap.sudan, R.mipmap.suriname, R.mipmap.svalbard,
            R.mipmap.swaziland, R.mipmap.sweden, R.mipmap.switzerland, R.mipmap.syria, R.mipmap.taiwan, R.mipmap.tajikistan, R.mipmap.tanzania, R.mipmap.thailand,
            R.mipmap.timor_leste, R.mipmap.togo, R.mipmap.tokelau, R.mipmap.tonga, R.mipmap.trinidad_and_tobago, R.mipmap.tunisia, R.mipmap.turkey, R.mipmap.turkmenistan,
            R.mipmap.turks_and_caicos_islands, R.mipmap.tuvalu, R.mipmap.uganda, R.mipmap.ukraine, R.mipmap.united_arab_emirates, R.mipmap.united_kingdom, R.mipmap.united_states, R.mipmap.uruguay,
            R.mipmap.uzbekistan, R.mipmap.vanuatu, R.mipmap.vatican_ city, R.mipmap.venezuela, R.mipmap.vietnam, R.mipmap.wallis_and_futuna, R.mipmap.western_sahara,
            R.mipmap.yemen, R.mipmap.zambia, R.mipmap.zimbabwe

//            R.mipmap.afghanistan,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
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
            "AFN", "ALL", "DZD", "USD", "EUR", "AOA", "XCD",
            "XCD", "ARS", "AMD", "AWG", "AUD", "EUR", "AZM", "BSD",
            "BHD", "BDT", "BBD", "BYR", "EUR", "BZD", "XOF", "BMD",
            "BTN", "BOB", "BAM", "BWP", "BRL", "USD",
            "BND", "BGN", "XOF", "BIF", "KHR", "XAF", "CAD", "CVE",
            "KYD", "XAF", "XAF", "CLP", "CNY", "AUD", "AUD",
            "COP", "KMF", "XAF", "NZD", "CRC", "XOF", "HRK", "CUP",
            "CYP    ", "CZK", "CDF", "DKK", "DJF", "XCD", "DOP",
            "USD", "EGP", "USD", "XAF", "ERN", "EEK", "ETB", "DKK",
            "FKP", "FJD", "EUR", "MKD", "EUR", "EUR", "XPF",
            "XAF", "GMD", "GEL", "EUR", "GHC", "GIP", "EUR", "DKK",
            "XCD", "EUR", "USD", "GTQ", "GNF", "XOF", "GYD", "HTG",
            "HNL", "HKD", "HUF", "ISK", "INR", "IDR", "IRR", "IQD",
            "EUR", "ILS", "EUR", "JMD", "JPY", "JOD", "KZT", "KES",
            "AUD", "KWD", "KGS", "LAK", "LVL", "LBP", "LSL", "LRD",
            "LYD", "CHF", "LTL", "EUR", "MOP", "MGF", "MWK", "MYR",
            "MVR", "XOF", "MTL", "USD", "EUR", "MRO", "MUR", "EUR",
            "MXN", "USD", "MDL", "EUR", "MNT", "XCD", "MAD", "MZM",
            "MMK", "NAD", "AUD", "NPR", "EUR", "ANG", "XPF", "NZD",
            "NIO", "XOF", "NGN", "NZD", "AUD", "KPW", "USD",
            "NOK", "OMR", "PKR", "USD", "PAB", "PGK", "PYG",
            "PEN", "PHP", "NZD", "PLN", "EUR", "USD", "QAR",
            "EUR", "ROL", "RUB", "RWF", "SHP", "XCD", "XCD",
            "EUR", "XCD", "WST", "EUR", "STD", "SAR", "XOF",
            "YUM", "SCR", "SLL", "SGD", "SKK", "SIT", "SBD", "SOS",
            "ZAR", "", "KRW", "EUR", "LKR", "SDD", "SRG", "NOK",
            "SZL", "SEK", "CHF", "SYP", "TWD", "TJS", "TZS", "THB",
            "USD", "XOF", "NZD", "TOP", "TTD", "TND", "TRL", "TMM",
            "USD", "AUD", "UGX", "UAH", "AED", "GBP", "USD", "UYU",
            "USD", "UZS", "VUV", "EUR", "VEB", "VND", "XPF", "MAD",
            "YER", "ZMK", "ZWD"
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
