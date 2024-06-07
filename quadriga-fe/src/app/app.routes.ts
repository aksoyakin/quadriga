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
];
