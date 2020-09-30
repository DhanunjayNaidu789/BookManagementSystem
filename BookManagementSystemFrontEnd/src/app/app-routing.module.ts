import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { SeeCustomerByIdComponent } from './see-customer-by-id/see-customer-by-id.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { ViewAllCustomersComponent } from './view-all-customers/view-all-customers.component';


const routes: Routes = [



  {path: '', redirectTo: 'view-all-customers', pathMatch: 'full' },
  { path: 'view-all-customers', component: ViewAllCustomersComponent },  
  
    { path: 'create-customer', component:  CreateCustomerComponent   },


    {path:'update-customer/:id',component:UpdateCustomerComponent},


    {path:'see-customer-by-id/:id',component:SeeCustomerByIdComponent}



];






@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
