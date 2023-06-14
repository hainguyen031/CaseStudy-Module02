package service.search;

public class SearchFactory {
    private static final SearchFactory searchFactory = new SearchFactory();

    private SearchFactory() {
    }

    public static SearchFactory getInstance() {
        return searchFactory;
    }

    public Search getSearch(String searchBy) {
        Search newSearch = SearchByModel.getInstance();
        switch (searchBy) {
            case "model":
                return SearchByModel.getInstance();
            case "price":
                return SearchByPrice.getInstance();
            case "seat":
                return SearchBySeat.getInstance();
            default:
                System.err.println("Error");
        }
        return newSearch;
    }
}
