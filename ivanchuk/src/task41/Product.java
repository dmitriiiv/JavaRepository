package task41;

public enum Product {
    MILK {
        @Override
        public String toString() {
            return "Молоко";
        }
    },
    BREAD {
        @Override
        public String toString() {
            return "Хлеб";
        }
    },
    ICE_CREAM {
        @Override
        public String toString() {
            return "Мороженое";
        }
    },
    SOUR_CREAM {
        @Override
        public String toString() {
            return "Сметана";
        }
    },
    CHEESE {
        @Override
        public String toString() {
            return "Сыр";
        }
    },
    COTTAGE_CHEESE {
        @Override
        public String toString() {
            return "Творог";
        }
    }
}