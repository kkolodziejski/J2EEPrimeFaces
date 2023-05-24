package pl.kkolodziejski.primefaces.jsfBeans;

import pl.kkolodziejski.primefaces.model.Kit;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ViewKits {
    private List<Kit> kits = new ArrayList<Kit>();

    public ViewKits() {
    }

    @PostConstruct
    public void populateKitList() {
        for (int i = 1; i <= 20; i++) {
            Kit kit = new Kit();
            kit.setId((long) i);
            kit.setName("Kit number: "+i);
            kit.setPieceCount(i*15);
            this.kits.add(kit);
        }
    }

    public List<Kit> getKits() {
        return kits;
    }

    public void setKits(List<Kit> kits) {
        this.kits = kits;
    }
}
