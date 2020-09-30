import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../CustomerService';
import { CustomerDetailsDto } from '../Model/CustomerDetails';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  id: number;
  customer:any;


  constructor(private route: ActivatedRoute,private router: Router,private customerService:CustomerService) { }

  ngOnInit(){


    this.customer = new CustomerDetailsDto();

    this.id = this.route.snapshot.params['id'];
    
    this.customerService.getEmployee(this.id)
      .subscribe(data => {
        console.log(data)
        this.customer = data;
      }, error => console.log(error));







  }

  updateEmployee() {
    this.customerService.updateEmployee(this.id, this.customer)
      .subscribe(data => {
        console.log(data);
        this.customer = new CustomerDetailsDto();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/view-all-customers']);
  }



}
