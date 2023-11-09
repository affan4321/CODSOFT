// This is Task 5     <<<< Address Book System >>>>

import java.util.*;
import java.io.*;


public class codSoftTask5 {
    public static void print(String str) { 
        System.out.println(str);
    }


    public static class AddressBook{
        // Instance Variables
        private Contact ct[];
        private int size;

        // Constructor
        AddressBook(){
            this.ct = null;
            this.size = 0;
        }
        AddressBook(Contact ct[], int size){
            this.size = size;
            this.ct = new Contact[size];
            for(int i=0; i< size; i++){
                this.ct[i] = new Contact(this.ct[i].getName(), this.ct[i].getPhoneNum(), this.ct[i].getEmail(), this.ct[i].getServiceProvider());
            }
        }
        AddressBook(final AddressBook ab){  // Copy constructor
            this.size = ab.size;
            this.ct = new Contact[ab.size];
            for(int i=0;i<size; i++){
                this.ct[i] = new Contact(ab.ct[i].Name, ab.ct[i].PhoneNum, ab.ct[i].Email, ab.ct[i].serviceProvider);
            }
        }

        // public methods
        public void addNewContact(){
            // Initializing scanner object
            Scanner sc = new Scanner(System.in);

            // Initializing all parameters of Contact
            String n,p,e,sp;

            print("Enter the Name: ");
            n = sc.nextLine();
            print("Enter the Phone Number: ");
            p = sc.nextLine();
            print("Enter the Email Address: ");
            e = sc.nextLine();
            print("Enter the Service Provider: ");
            sp = sc.nextLine();
            
            

            // If already empty
            if(this.size == 0){
                this.size++;
                this.ct = new Contact[size];
                this.ct[0] = new Contact(n,p,e,sp);
            }
            else{
                this.size++;
                AddressBook temp = new AddressBook();
                temp.size = this.size;
                temp.ct = new Contact[this.size];
                for(int i=0;i<this.size-1; i++){
                    temp.ct[i] = new Contact(this.ct[i].Name, this.ct[i].PhoneNum, this.ct[i].Email, this.ct[i].serviceProvider);
                }

                // Adding new Contact
                temp.ct[this.size-1] = new Contact(n,p,e,sp);

                this.ct = temp.ct;
            }

            print("*****New Contact added successfully*****\n");
        }

        public void editContact(){
            // Initializing scanner object
            Scanner sc = new Scanner(System.in);

            // Showing all Contacts
            print("Which Contact you want to edit?\n");
            this.displayAll();
            print("Press it's number\n");
            int location = sc.nextInt();
            location--;

            print("What do you want to edit?\nPress 1 to edit Name\nPress 2 to edit Phone Number\nPress 3 to edit Email Address\nPress 4 to edit Service Provider\n");
            switch(sc.nextInt()){
                case 1:
                {
                    print("Enter new name: ");
                    sc.nextLine();
                    this.ct[location].Name = sc.nextLine();
                    break;
                }
                case 2:
                {
                    print("Enter new Phone Number: ");
                    sc.nextLine();
                    this.ct[location].PhoneNum = sc.nextLine();
                    break;
                }
                case 3:
                {
                    print("Enter new Email Address: ");
                    sc.nextLine();
                    this.ct[location].Email = sc.nextLine();
                    break;
                }
                case 4:
                {
                    print("Enter new Service Provider: ");
                    sc.nextLine();
                    this.ct[location].serviceProvider = sc.nextLine();
                    break;
                }
                default:
                {
                    print("Invalid option selected\n");
                    break;
                }
            }
            print("*****Contact edited successfully*****\n");
        }

        public int searchContact(){
            // Initializing scanner object
            Scanner sc = new Scanner(System.in);

            print("How do you want to search?\n");
            print("Press 1 to search by Name\n");
            print("Press 2 to search by Phone Number\n");
            print("Press 3 to search by Email Address\n");

            switch (sc.nextInt()) {
                case 1:
                {   
                    print("Enter name: ");
                    sc.nextLine();
                    String Name = sc.nextLine();
                    
                    for(int i=0; i< this.size; i++){
                        if(this.ct[i].Name.equals(Name)){
                            print("*****Contact found at: " + (i+1) + "*****\n");
                            return i; // Returns the position
                        }
                    }
                    break;
                }
                case 2:
                {
                    print("Enter Phone num: ");
                    sc.nextLine();
                    String PhoneNum = sc.nextLine();
                    for(int i=0; i< this.size; i++){
                        if(this.ct[i].PhoneNum.equals(PhoneNum)){
                            print("*****Contact found at: " + (i+1) + "*****\n");
                            return i; // Returns the position
                        }
                    }
                    break;
                }
                case 3:
                {
                    print("Enter Email: ");
                    sc.nextLine();
                    String Email = sc.nextLine();
                    for(int i=0; i< this.size; i++){
                        if(this.ct[i].Email.equals(Email)){
                            print("*****Contact found at: " + (i+1) + "*****\n");
                            return i; // Returns the position
                        }
                    }
                    break;
                }
                default:
                    print("Invalid option\n");
                    break;
            }
            print("*****Contact was not found!*****\n");
            return -1;  // Incase not found
        }


        public void displayAll(){
            if(this.size == 0){
                print("*****The AddressBook is currently empty*****\n");
            }
            else{
                print("*****Showing all Contacts in the Addressbook*****\n");
                for(int i=0;i<this.size; i++){
                    print(i+1 + ") Name: " + this.ct[i].Name + ", Phone Num: " + this.ct[i].PhoneNum + ", Email: " + this.ct[i].Email + ", Service Provider: " + this.ct[i].serviceProvider + "\n");
                }
            }
        }

    }


    public static class Contact{
        // Instance Variables
        private String Name;
        private String PhoneNum;
        private String Email;
        private String serviceProvider;

        // Constructor
        Contact(){
            this.Name = "";
            this.PhoneNum = "";
            this.Email = "";
            this.serviceProvider = "";
        }
        Contact(String n, String p, String e, String sp){
            this.Name = n;
            this.PhoneNum = p;
            this.Email = e;
            this.serviceProvider = sp;
        }

        // Getter & Setters
        public String getName(){ return this.Name; }
        public String getPhoneNum(){ return this.PhoneNum; }
        public String getEmail(){ return this.Email; }
        public String getServiceProvider(){ return this.serviceProvider; }

        public void setName(String val){ this.Name = val; }
        public void setPhoneNum(String val){ this.PhoneNum = val; }
        public void setEmail(String val){ this.Email = val; }
        public void setServiceProvider(String val){ this.serviceProvider = val; }


    }

    public static void main(String[] args) {

        // Initializing scanner object
        Scanner sc = new Scanner(System.in);

        // Initializing new Addressbook object
        AddressBook ab = new AddressBook();

        //Loop
        boolean loop = true;

        while(loop){
            // GUI for the Addressbook System
            print("//////////  Welcome in the AddressBook   //////////\n");
            print("            Press 1 to Add new Contact\n");
            print("            Press 2 to Edit Contact\n");
            print("            Press 3 to Search Contact\n");
            print("            Press 4 to Show all Contacts\n");
            print("            Press 5 to exit\n");
            print("-> ");

            switch (sc.nextInt()) {
                case 1:
                    ab.addNewContact();
                    break;
                case 2:
                    ab.editContact();
                    break;

                case 3:
                    ab.searchContact();
                    break;

                case 4:
                    ab.displayAll();
                    break;
                default:
                    loop = false;
                    break;
            }
        }
    }
    
}
