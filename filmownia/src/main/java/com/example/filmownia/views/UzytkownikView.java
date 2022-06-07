package com.example.filmownia.views;


import com.example.filmownia.Uzytkownik;
import com.example.filmownia.UzytkownikRepository;
import com.example.filmownia.UzytkownikService;
import com.example.filmownia.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.lang.Long.parseLong;

@Route(value = "uzytkownik-view", layout = MainLayout.class)
public class UzytkownikView extends HorizontalLayout {


    final Grid<Uzytkownik> grid;
    private final UzytkownikService uzytkownikService;

    @Autowired


    public UzytkownikView(UzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
        this.grid = new Grid<>(Uzytkownik.class);
        add(grid);
        listUsers();
    }

    private void listUsers(){
        List<Uzytkownik> allUsers = (List<Uzytkownik>) uzytkownikService.getUzytkownikow();
        grid.setItems(allUsers);
    }
/*private TextField txtid, txtlogin,
            txthaslo;
    private Button btnAddNew;
    private ListBox<Uzytkownik> listBox =
            new ListBox<>();
    private UzytkownikRepository repo;
    @Autowired
    public UzytkownikView(UzytkownikRepository repo){
        this.repo = repo;
        listBox.setItems(repo.findAll());
        listBox.setRenderer(new ComponentRenderer<>(uzytkownik -> {
            Label name = new Label("Id: " + uzytkownik.getId());
            Label phone = new Label("Login: " + uzytkownik.getLogin());
            Label email = new Label("Email: " + uzytkownik.getHaslo());
            NativeButton button = new NativeButton("Delete",
                    event -> {
                        repo.delete(uzytkownik);
                        clearFormData();
                        listBox.getDataProvider().refreshItem(uzytkownik);
                    });
            Div labels = new Div(txtid, txtlogin, txthaslo);
            Div layout = new Div(labels, button);
            labels.getStyle().set("display", "flex")
                    .set("flexDirection", "column")
                    .set("marginRight", "10px");
            layout.getStyle().set("display", "flex")
                    .set("alignItems", "center");
            return layout;
        }));
        listBox.setItemEnabledProvider(uzytkownik-> {
            Optional<Uzytkownik> uzytkownik1 = repo.findById(uzytkownik.getId());
            if (uzytkownik1!=null)
                return true;
            else
                return false;
        });
        listBox.addValueChangeListener(event ->
                populateForm(listBox.getValue()));
        add(listBox, createForm());
    }

    public void populateForm(Uzytkownik uzytkownik){
        txtid.setValue(String.valueOf(uzytkownik.getId()));
        txtlogin.setValue(uzytkownik.getLogin());
        txthaslo.setValue(uzytkownik.getHaslo());
    }
    private FormLayout createForm(){
        FormLayout f = new FormLayout();
        txtid = new TextField("Id");
        txtlogin = new TextField("Login");
        txthaslo = new TextField("Haslo");
        btnAddNew = new Button("Add New",
                VaadinIcon.PLUS.create());
        btnAddNew.addClickListener(event->save());
        f.add(txtid, txtlogin, txthaslo,btnAddNew);
        return f;
    }

    private void save(){
        if (txtid.isEmpty() || txtlogin.isEmpty()
                || txthaslo.isEmpty()) {
            Notification.show("Input data cannot be empty");
            return;
        }
        Optional<Uzytkownik> uzytkownik = repo.findById(parseLong(txtid.getValue()));
        if (uzytkownik==null) {
            repo.save(new Uzytkownik(txtlogin.getValue(), txthaslo.getValue()));
            listBox.setItems(repo.findAll());
        }else{
            Notification.show("Cannot save. Same nam exists. Try different name.");
        }
        clearFormData();
    }

    public void clearFormData(){
        txtid.setValue("");
        txtlogin.setValue("");
        txthaslo.setValue("");
    }
*/







}
