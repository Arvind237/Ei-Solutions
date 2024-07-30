import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

class PhoneDisplay implements Observer {
    public void update(float temperature) {
        System.out.println("Phone display updated: " + temperature);
    }
}

class ComputerDisplay implements Observer {
    public void update(float temperature) {
        System.out.println("Computer display updated: " + temperature);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        ComputerDisplay computerDisplay = new ComputerDisplay();

        station.addObserver(phoneDisplay);
        station.addObserver(computerDisplay);

        station.setTemperature(25.5f);
    }
}
