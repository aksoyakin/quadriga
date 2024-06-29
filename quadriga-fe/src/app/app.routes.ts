import { Routes } from '@angular/router';
import { CreateBrandComponent } from './features/brand/create-brand/create-brand.component';
import { BrandsListComponent } from './features/brand/brands-list/brands-list.component';
import { UpdateBrandComponent } from './features/brand/update-brand/update-brand.component';
import { BrandDetailsComponent } from './features/brand/brand-details/brand-details.component';
import { ModelListComponent } from './features/model/model-list/model-list.component';
import { CreateModelComponent } from './features/model/create-model/create-model.component';
import { UpdateModelComponent } from './features/model/update-model/update-model.component';
import { ModelDetailsComponent } from './features/model/model-details/model-details.component';
import { CategoryListComponent } from './features/category/category-list/category-list.component';
import { CreateCategoryComponent } from './features/category/create-category/create-category.component';
import { UpdateCategoryComponent } from './features/category/update-category/update-category.component';
import { CategoryDetailsComponent } from './features/category/category-details/category-details.component';
import { ColorsListComponent } from './features/color/colors-list/colors-list.component';
import { CreateColorComponent } from './features/color/create-color/create-color.component';
import { UpdateColorComponent } from './features/color/update-color/update-color.component';
import { ColorDetailsComponent } from './features/color/color-details/color-details.component';
import { FuelTypesListComponent } from './features/fueltype/fueltypes-list/fueltypes-list.component';
import { CreateFuelTypeComponent } from './features/fueltype/create-fueltype/create-fueltype.component';
import { UpdateFuelTypeComponent } from './features/fueltype/update-fueltype/update-fueltype.component';
import { FuelTypeDetailsComponent } from './features/fueltype/fueltype-details/fueltype-details.component';
import { TransmissionTypesListComponent } from './features/transmissiontype/transmissiontypes-list/transmissiontypes-list.component';
import { CreateTransmissionTypeComponent } from './features/transmissiontype/create-transmissiontype/create-transmissiontype.component';
import { UpdateTransmissionTypeComponent } from './features/transmissiontype/update-transmissiontype/update-transmissiontype.component';
import { TransmissionTypeDetailsComponent } from './features/transmissiontype/transmissiontype-details/transmissiontype-details.component';
import { CarListComponent } from './features/car/car-list/car-list.component';
import { CreateCarComponent } from './features/car/create-car/create-car.component';
import { UpdateCarComponent } from './features/car/update-car/update-car.component';
import { CarDetailsComponent } from './features/car/car-details/car-details.component';
import { CarsCardComponent } from './shared/components/cars-card/cars-card.component';


export const routes: Routes = [
    //brands
    {path: 'brands/brands-list', component: BrandsListComponent},
    {path: 'brands/create-brand', component: CreateBrandComponent},
    {path: 'brands/update-brand/:id', component: UpdateBrandComponent},
    {path: 'brands/brand-details/:id', component:BrandDetailsComponent},
    //models
    {path: 'models/models-list', component: ModelListComponent},
    {path: 'models/create-model', component: CreateModelComponent},
    {path: 'models/update-model/:id', component: UpdateModelComponent},
    {path: 'models/model-details/:id', component: ModelDetailsComponent},
    //categories
    {path: 'categories/category-list', component: CategoryListComponent},
    {path: 'categories/create-category', component: CreateCategoryComponent},
    {path: 'categories/update-category/:id', component: UpdateCategoryComponent},
    {path: 'categories/category-details/:id', component: CategoryDetailsComponent},
    //colors
    {path: 'colors/colors-list', component: ColorsListComponent},
    {path: 'colors/create-color', component: CreateColorComponent},
    {path: 'colors/update-color/:id', component: UpdateColorComponent},
    {path: 'colors/color-details/:id', component: ColorDetailsComponent},
    //fueltypes
    {path: 'fueltypes/fueltypes-list', component: FuelTypesListComponent},
    {path: 'fueltypes/create-fueltype', component: CreateFuelTypeComponent},
    {path: 'fueltypes/update-fueltype/:id', component: UpdateFuelTypeComponent},
    {path: 'fueltypes/fueltype-details/:id', component: FuelTypeDetailsComponent},
    //transmissiontypes
    {path: 'transmissiontypes/transmissiontypes-list', component: TransmissionTypesListComponent},
    {path: 'transmissiontypes/create-transmissiontype', component: CreateTransmissionTypeComponent},
    {path: 'transmissiontypes/update-transmissiontype/:id', component: UpdateTransmissionTypeComponent},
    {path: 'transmissiontypes/transmissiontype-details/:id', component: TransmissionTypeDetailsComponent},
    //cars
    {path: 'cars/cars-list', component: CarListComponent},
    {path: 'cars/create-car', component: CreateCarComponent},
    {path: 'cars/update-car/:id', component: UpdateCarComponent},
    {path: 'cars/car-details/:id', component: CarDetailsComponent},
    
    
    //category
    {path: 'category/:id', component: CarsCardComponent},
    {path: 'category', component: CarsCardComponent},
    {path: 'cars', component: CarsCardComponent},
/*     {path: '', redirectTo: '/cars', pathMatch: 'full'},
    {path: '**', redirectTo: '/cars', pathMatch: 'full'}, */
];
