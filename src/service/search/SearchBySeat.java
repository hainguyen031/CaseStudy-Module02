package service.search;

import entity.Car;
import service.CarService;
import service.InputService;

import java.util.ArrayList;
import java.util.List;

public class SearchBySeat implements Search{
    private static final SearchBySeat searchBySeat = new SearchBySeat();

    private SearchBySeat() {
    }

    public static SearchBySeat getInstance() {
        return searchBySeat;
    }

    @Override
    public List<Integer> searchByCondition() {
        return SearchBySeat();
    }

    private List<Integer> SearchBySeat() {
        List<Integer> result = new ArrayList<>();
        int seat = Integer.parseInt(InputService.getInstance().inputInfo("seat"));
        for (Car car : CarService.getInstance().getCarList()) {
            if ((car.getSeats() == seat) && (car.isAvailable())) {
                result.add(car.getId());
            }
        }
        return result;
    }
}
