import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../CustomerService';
import { CustomerDetailsDto } from '../Model/CustomerDetails';

@Component({
  selector: 'app-see-customer-by-id',
  templateUrl: './see-customer-by-id.component.html',
  styleUrls: ['./see-customer-by-id.component.css']
})
export class SeeCustomerByIdComponent implements OnInit {

  id: number;
  customer: any;



  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: CustomerService) { }

  ngOnInit() {

    this.customer = new CustomerDetailsDto();

    this.id = this.route.snapshot.params['id'];
    
    this.employeeService.getEmployee(this.id)
      .subscribe(data => {
        console.log(data)
        this.customer = data;
      }, error => console.log(error));








  }

}
