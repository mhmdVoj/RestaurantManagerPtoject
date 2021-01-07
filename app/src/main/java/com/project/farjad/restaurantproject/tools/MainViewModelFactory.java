package com.project.farjad.restaurantproject.tools;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.project.farjad.restaurantproject.database.RestaurantDao;
import com.project.farjad.restaurantproject.viewModels.CustomerDetailViewModel;
import com.project.farjad.restaurantproject.viewModels.CustomerFragmentViewModel;
import com.project.farjad.restaurantproject.viewModels.DetailFoodViewModel;
import com.project.farjad.restaurantproject.viewModels.FactorChangeViewModel;
import com.project.farjad.restaurantproject.viewModels.FinancialFragmentViewModel;
import com.project.farjad.restaurantproject.viewModels.FoodChangeViewModel;
import com.project.farjad.restaurantproject.viewModels.HomeViewModel;
import com.project.farjad.restaurantproject.viewModels.LogInViewModel;
import com.project.farjad.restaurantproject.viewModels.MoshtariChangeViewModel;
import com.project.farjad.restaurantproject.viewModels.PersonnelViewModel;
import com.project.farjad.restaurantproject.viewModels.ReportViewModel;
import com.project.farjad.restaurantproject.viewModels.ReserveChangeViewModel;
import com.project.farjad.restaurantproject.viewModels.SearchViewModel;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private RestaurantDao restaurantDao;

    public MainViewModelFactory(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class))
            return (T) new HomeViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(DetailFoodViewModel.class))
            return (T) new DetailFoodViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(SearchViewModel.class))
            return (T) new SearchViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(ReportViewModel.class))
            return (T) new ReportViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(FoodChangeViewModel.class))
            return (T) new FoodChangeViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(LogInViewModel.class))
            return (T) new LogInViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(MoshtariChangeViewModel.class))
            return (T) new MoshtariChangeViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(CustomerFragmentViewModel.class))
            return (T) new CustomerFragmentViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(CustomerDetailViewModel.class))
            return (T) new CustomerDetailViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(ReserveChangeViewModel.class))
            return (T) new ReserveChangeViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(FactorChangeViewModel.class))
            return (T) new FactorChangeViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(FinancialFragmentViewModel.class))
            return (T) new FinancialFragmentViewModel(restaurantDao);
        else if (modelClass.isAssignableFrom(PersonnelViewModel.class))
            return (T) new PersonnelViewModel(restaurantDao);
        else throw new IllegalArgumentException("View model Class not valid (Main View Model Factory returns)");
    }
}
