package tmp.view;

import tmp.controller.Controller;
import tmp.controller.ListController;
import tmp.model.ListModel;
import tmp.model.Model;

import java.util.Collection;

/**
 * ������������� ������
 * @param <P> �������� ������
 */
public abstract class ListView<P> extends
        BaseView<ListModel<P>, Collection<Model<P>>> {
    private final Controller<P> controller = new Controller<P>();

    private final ListController<P> listController = new ListController<P>();

    /**
     * ������������� ������
     * @param model ������
     * @param property �������� ������
     */
    protected void edit(Model<P> model, P property) {
        controller.execute(Controller.O.EDIT, model, property);
    }

    /**
     * �������� ������
     * @param model ������
     */
    protected void add(Model<P> model) {
        listController.execute(ListController.O.ADD, getModel(), model);
    }

    /**
     * ������� ������
     * @param model ������
     */
    protected void delete(Model<P> model) {
        listController.execute(ListController.O.REMOVE, getModel(), model);
    }
}
