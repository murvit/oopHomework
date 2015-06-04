package tmp.view;

import tmp.controller.Controller;
import tmp.controller.ListController;
import tmp.model.ListModel;
import tmp.model.Model;

import java.util.Collection;

/**
 * Представление списка
 * @param <P> свойство модели
 */
public abstract class ListView<P> extends
        BaseView<ListModel<P>, Collection<Model<P>>> {
    private final Controller<P> controller = new Controller<P>();

    private final ListController<P> listController = new ListController<P>();

    /**
     * Редактировать модель
     * @param model модель
     * @param property свойство модели
     */
    protected void edit(Model<P> model, P property) {
        controller.execute(Controller.O.EDIT, model, property);
    }

    /**
     * Добавить модель
     * @param model модель
     */
    protected void add(Model<P> model) {
        listController.execute(ListController.O.ADD, getModel(), model);
    }

    /**
     * Удалить модель
     * @param model модель
     */
    protected void delete(Model<P> model) {
        listController.execute(ListController.O.REMOVE, getModel(), model);
    }
}
