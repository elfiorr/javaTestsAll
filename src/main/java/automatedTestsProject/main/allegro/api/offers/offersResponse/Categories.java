
package automatedTestsProject.main.allegro.api.offers.offersResponse;

import java.util.List;

public class Categories {

    private List<Subcategory> subcategories = null;
    private List<Path> path = null;

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public List<Path> getPath() {
        return path;
    }

    public void setPath(List<Path> path) {
        this.path = path;
    }

}
