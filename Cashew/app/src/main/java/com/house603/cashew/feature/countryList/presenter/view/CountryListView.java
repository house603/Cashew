package com.house603.cashew.feature.countryList.presenter.view;

import com.house603.cashew.base.presenter.LoadDataView;
import com.house603.cashew.model.CurrencyModel;

/**
 * Created by Admin on 2/25/2017.
 */

public interface CountryListView extends LoadDataView {
    void setCurrencyModel(CurrencyModel model);
}
