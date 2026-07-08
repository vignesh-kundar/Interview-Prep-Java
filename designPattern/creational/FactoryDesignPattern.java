class FactoryDesignPattern {
    public static void main (String args []) {
        // Example of an Factory Design Pattern

        // Problem Statement :
        // Logistic company with different shipping methods!

        // solution :
        System.out.println("Factory Design Pattern, Example : ");
        String mode = "sea";
        try {
            factory( mode ).shipGoods();
        } catch (Exception e) {
            System.out.println("Oops Exception occured : " + e.getMessage());
        }

    }


    public static Logistics factory( String mode ) throws Exception{
        switch (mode) {
            case "air" -> { return new ShipViaAir(); }
            case "sea" -> { return new ShipViaSea(); }
            case "land" -> { return new ShipViaRoad(); }
            case "drone" -> { return new ShipViaDrone(); }
            default -> {
                throw new Exception("No Mode Implementation found!");
            }}
    }

    public enum LogisticsMode {
        air , sea , land , drone
    }

    // Interface
    interface Logistics {
        void shipGoods();
    }

    // Solid Class Implementation
    static class ShipViaSea implements Logistics {
        @Override
        public void shipGoods() {
            System.out.println("Shipping Goods via sea");
        }
    }

    static class ShipViaAir implements Logistics {
        @Override
        public void shipGoods() {
            System.out.println("Shipping Goods via Air");
        }
    }

    static class ShipViaRoad implements Logistics {
        @Override
        public void shipGoods() {
            System.out.println("Shipping Goods via Road");
        }
    }

    static class ShipViaDrone implements Logistics {
        @Override
        public void shipGoods() {
            System.out.println("Shipping Goods via Drone");
        }
    }

}