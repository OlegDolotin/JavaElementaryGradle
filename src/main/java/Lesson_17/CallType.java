package Lesson_17;

public enum CallType {
    canceled{
        @Override
        public String toString() {
            return "canceled";
        }
    },
    incoming{
        @Override
        public String toString() {
            return "incoming";
        }
    },
    outcoming{
        @Override
        public String toString() {
            return "outcoming";
        }
    };
}
