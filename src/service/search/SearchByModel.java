package service.search;

import entity.Car;
import service.CarService;
import service.InputService;

import java.util.ArrayList;
import java.util.List;

public class SearchByModel implements Search {
    private static final SearchByModel searchByModel = new SearchByModel();

    private SearchByModel() {
    }

    public static SearchByModel getInstance() {
        return searchByModel;
    }

    @Override
    public List<Integer> searchByCondition() {
        return searchByModel();
    }

    private List<Integer> searchByModel() {
        List<Integer> result = new ArrayList<>();
        String model = InputService.getInstance().inputInfo("model");
        for (Car car : CarService.getInstance().getCarList()) {
            if (car.getModel().contains(model) && (car.isAvailable())) {
                result.add(car.getId());
            }
        }
        return result;
    }
}
