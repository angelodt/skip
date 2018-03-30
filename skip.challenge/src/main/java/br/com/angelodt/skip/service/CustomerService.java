package br.com.angelodt.skip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angelodt.skip.model.Customer;
import br.com.angelodt.skip.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired 
    private CustomerRepository customerRepository;

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void authenticate(String email, String password) throws Exception {
        Customer c = customerRepository.findByEmail(email);
        if(!c.getPassword().equals(password)) {
            throw new Exception("User and Password not found.");
        }
    }

    public void addCustomer(Customer newCustomer) throws Exception {
        try {
            Customer c = customerRepository.findByEmail(newCustomer.getEmail());
            if(c != null) {
                throw new Exception("There is already an account with this email!");
            } else {
                customerRepository.save(newCustomer);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
