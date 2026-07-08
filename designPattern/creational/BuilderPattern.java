class BuilderPattern {
    public static void main(String args[]) {
        // Example of Builder Pattern!
        System.out.println("Builder Pattern example!");

        // Problem :
        /*
        * The problem is that the class creation using constructor for a class with lot of fields will be too long and it is not even clear which objects are mapped to which (Readability)
        * To Solve this issiue there is this Builder Design Pattern!
        */

        // Creating House Method (Constructor Method)
        // - This way of creating an house object has Readability prolem + Lengthy Constructor
        House houseUsingConstructor = new House(true , true , true , true ,true);

        // Using Builder Pattern
        House houseUsingBuilder = House.


    }

    // Interface
    interface HouseBuilder {
        void setSwimmingPool( Boolean swim );
        void setGarden( Boolean garden );
        void setBalcony( Boolean balcony );
        void setGarrage( Boolean garrage );
        void setFancyStatue( Boolean fancyStatue );
    }

    static class House implements HouseBuilder {
        private Boolean swimmingPool;
        private Boolean garden;
        private Boolean balcony;
        private Boolean garrage;
        private Boolean fancyStatue;

        public House() {}
        public House( Boolean swim , Boolean garden , Boolean balcony , Boolean garrage , Boolean fancyStatue ) {
            this.swimmingPool = swim;
            this.garden = garden;
            this.balcony = balcony;
            this.garrage = garrage;
            this.fancyStatue = fancyStatue;
        }

        @Override
        public void setSwimmingPool( Boolean swim ){
            this.swimmingPool = swim;
        }
        @Override
        public void setGarden( Boolean garden) {
            this.garden = garden;
        }
        @Override
        public void setBalcony( Boolean balcony ){
            this.balcony = balcony;
        }
        @Override
        public void setGarrage( Boolean garrage) {
            this.garrage = garrage;
        }
        @Override
        public void setFancyStatue( Boolean fancyStatue ) {
            this.fancyStatue = fancyStatue;
        }

        public House build() {
            return new House( swimmingPool , garden , balcony , garrage , fancyStatue );
        }
    }


}