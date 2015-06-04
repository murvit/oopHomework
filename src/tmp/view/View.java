package tmp.view;


import tmp.controller.Controller;
import tmp.model.Model;

/**
 * �������������
 * @param <P> �������� ������
 */
public abstract class View<P> extends BaseView<Model<P>, P> {
    private final Controller<P> controller = new Controller<P>();

    /**
     * ������������� ������
     * @param property �������� ������
     */
    protected void edit(P property) {
        controller.execute(Controller.O.EDIT, getModel(), property);
    }
}