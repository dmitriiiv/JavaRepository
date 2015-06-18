package task35;

import java.util.Locale;

public enum Locations {
    RU {
        @Override
        public Locale getLocation() {
            return new Locale("ru", "RU");
        }
    }, BY {
        @Override
        public Locale getLocation() {
            return new Locale("be", "BY");
        }
    }, US {
        @Override
        public Locale getLocation() {
            return new Locale("en", "UK");
        }
    };

    public abstract Locale getLocation();
}
