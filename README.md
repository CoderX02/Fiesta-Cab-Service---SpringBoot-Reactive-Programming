# Case study
The software to be developed is to support the operations of Fiesta Cab Service (FCS), specifically the administration of booking and rental vehicles for long distance trips and special functions. The customer should be able to book the vehicle at least 3 days prior to the event. This service doesn’t contain any real time booking facility or the location handling (GPS, etc.) FCS operates several subsidiaries across the country where each has a collection of vehicles and rents them to customers in the geographical area assigned to them according to the requirements set while a customer makes a booking. FCS has a number of supervisory staff who are responsible for customer bookings.
The entire region FCS operates in is divided into geographical areas, one for each subsidiary, and each customer is delivered vehicles from the subsidiary for the geographical area in which the customer is located. Every subsidiary has at least 1 customer in its area. Each customer is located in one place only, i.e. in only one subsidiary's area. Operator should be able to create, edit, delete customers (Both regular and Business) and search customers by mobile number.
Each vehicle (uniquely identified by a registration number) is available at only one subsidiary which may, however, rent out more than one vehicle.
The subsidiary location of vehicles does not ever change (a simplifying assumption).
The driver allocated to a booking event does not change except for rare occasions (e.g. Illness of drivers). A minimum of at least two alternative drivers are kept at each subsidiary (again, another simplifying assumption).
Customers make bookings. Some customers, however, have not yet made any booking. A customer can be either one of two types, Business (customers who approach the company on a regular basis) or Personal (customers who approach the organization occasionally). Customer will select the type of booking (Pick / Pick & Drop), date, time, current location and destination. A booking consists of vehicles (at least one), specifying the type of vehicle and the date of delivery. Operator will display all vehicles available for booking and confirm the booking by updating vehicle, supervisor and driver information. She/he is able to display all Driver details group by city.


When a vehicle is delivered, the vehicle booking is marked as delivered by entering the date of vehicle delivery. For Pick & Drop bookings, the vehicle return date is also recorded with the other booking details.
The customer is liable to pay for the hire at the time of vehicle delivery. (payment handling is not expected to develop in your system)
Each customer has a vehicle booking limit. This limit is the number of vehicles rented which may not be exceeded.
A confirmed customer booking is always notified to the customer 1 hour following the time of vehicle booking. The notification consists of Venue (Pick / Pick & Drop), Vehicle, Driver and Booking details.
The company employs supervisory staff. Each supervisory staff overlooks customer bookings that are directed from the one or more subsidiaries which are allocated exclusively to that staff. In addition, each vehicle at a subsidiary is assigned to a particular supervisory staff member who is responsible for checking the vehicle condition before and after the hire, but not all supervisory staffs are responsible for checking any vehicles.

System should be able to display all vehicles which are maintained by a particular supervisor.
The system should be able to generate the below reports.
* Display all pick booking including vehicle information along driver details
* Generate a list of top 5 subsidiaries which have hired out the most numbers of vehicles
for last 30days.
* Allow the system to enter a customer ID and produce a report that details all hires of
that customer in a suitable format. 
* Display all customers who have not placed any orders for last 100 days.