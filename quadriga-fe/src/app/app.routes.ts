import { Routes } from '@angular/router';
import { CreateBrandComponent } from './features/brand/create-brand/create-brand.component';
import { BrandsListComponent } from './features/brand/brands-list/brands-list.component';
import { UpdateBrandComponent } from './features/brand/update-brand/update-brand.component';
import { BrandDetailsComponent } from './features/brand/brand-details/brand-details.component';

export const routes: Routes = [
    //brands
    {path: 'brands/brands-list', component: BrandsListComponent},
    {path: 'brands/create-brand', component: CreateBrandComponent},
    {path: 'brands/update-brand/:id', component: UpdateBrandComponent},
    {path: 'brands/brand-details/:id', component:BrandDetailsComponent},
];
