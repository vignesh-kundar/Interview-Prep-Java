class OpenClosePrinciple {

    public static void main (String args[]) {
        // main method !
    }

    // Problem : class example that violates open close principle
    static class PaymentServicer {
        private Object employee;
        // some other properties..

        // example of sample method! - that violates the priciple
        public double calculatePay( Object employee ) {
            if ( employee.equals("MANAGER") ) {
                // perform certain operations for manager
            } else if ( employee.equals("DEVELOPER") ) {
                // perform certain operations for developer..
            }
            return 0.0;
        }

        /* The Abbove method violates the OCP
            - Because the ocp cearly says closed to modification
            - but if the code requires any change int he future then this method has to be modified!
            - Hence this voilates the Open close principle
        */
    }

    // Solution
    public interface  Employee {
        double calculatePay();
    }

    static class Developer implements Employee {
        @Override
        public double calculatePay() {
            // Calculate Developer pay here
            return 0.0;
        }
    }

    static class Manager implements Employee {
        @Override
        public double calculatePay() {
            // calculate Manager pay here
            return 0.0;
        }
    }

    // Usage :
//   - In this example we have used the interface to define the methods and created a concrete class out of it to be used to replace the if else condition,
//    and the benifit is that,
//    - if else code would require us to modify on every new Job role
//            - but the OCP priciple can be attained only by adding a new concrete class for the new JD
    public static class PayCalculatorService {
        public double calculatePay( Employee employee ) {
            // calculate Pay for the employee // manager , developer
            return employee.calculatePay();
        }
    }

}