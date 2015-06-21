package task36;

public enum Level {
    INFO {
        @Override
        public String getColor() {
            return "#009800";
        }
    },
    WARNING {
        @Override
        public String getColor() {
            return "#FFCC35";
        }
    },
    ERROR {
        @Override
        public String getColor() {
            return "#ff6347";
        }
    };

    public abstract String getColor();
}
