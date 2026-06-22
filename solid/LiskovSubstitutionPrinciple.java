class LiskovSubstitutionPrinciple {

    public static void main (String args []) {
        // Liskov Substituion principle states that
        // Object of the super class -> replacable -> Object of its sub classes
        // without checking the correctness of the programm
    }

    // problem :
    class Employee {
        String name;
        Long salary;

        public double payBonous() {
            // calculate bonus!
            return 0.0;
        }

        public double paySalary() {
            // calculate salary
            return 0.0;
        }
    }
    // some of the methods are overridden to throw exception
    class contractEmployee extends Employee {
        @Override
        public double payBonus() {
            throw new UnsupportedOperaitionException("Unsupported Operation");
        }
    }

    // The actual Violation of the LSP :
    Employee emp = new contractEmployee();
    emp.payBonus(); // will break!
    emp.paySalary(); // will work!

    // The problem is once it extends the class with the methods it should work with all its implementation!


    private class Soultion {

        // 1.use seperate interfaces to implement contactEmployee
        // 2.modify the payBonus stratergy -> it should be optional
        // 3.use BonusProcessor to process the bonus -> done let the single class decide it!

        // solution 3.
        interface BonusEligible { double payBonus(); }
        interface PayEligible { double paySalary(); }
        class ContractEmployee immlements PayEligible {  /*Buisness Logic*/ }

        class BonusProcessor {
            public processBonus( Employee emp ) {
                if (emp instanceof BonusEligible ) {
                    // log emp is not eligible for the Bonus!
                }
            }
        }

    }
}