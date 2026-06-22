class InterfaceSeggegrationPriciple {
    public static void main (String args[]) {
        // Many Interfaces are always better than one general one!
        // To prvenet unnecessary method implementation!
    }

    // problem
    class problem {
        interface generalInterface {
            public void attendMeeting();
            public void doWork();
            public void fillTimeSheet();
        }

        class Manager implements generalInterface { /*Core Logic*/ }
        class Engineer implements generalInterface { /*Core Logic*/ }
        class ContractEmployee implements generalInterface { /*Core Logic*/ } // here is the problem : contract emp has to only work!
        // manager is foreced to throw an excpetion on the fillTimeSheet
    }

    // solution
    class solution {
        // Seggegrate Interfaces to multiple pieces !
        // 3 seperate interfacces each focusing on seperate implementation
        interface Work { public void doWork(); }
        interface MettingAttendee { public void attendMeeting(); }
        interface TimeSheetSubmitter { public void fillTimeSheet(); }

        // Now implement whenever required
        class Manager implements Work , MettingAttendee { /*Core Buisness Logic*/ }
        class Engineer implements Work , TimeSheetSubmitter { /*Crre Buisness Logic*/ }
        class ContractEmployee implements Work { /*Core Buisness Logic*/ }
        // This way we can resolve unnecessary Method Implementations!
    }

}