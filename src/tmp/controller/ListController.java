package tmp.controller;

import tmp.model.ListModel;
import tmp.model.Model;

import java.util.Arrays;
import java.util.Collection;

/**
 * ���������� ������
 * @param <P> �������� ������
 */
public class ListController<P> implements
        IController<ListController.O, ListModel<P>, Collection<Model<P>>> {
    /**
     * �������� ��� ������� ������
     */
    public enum O {
        /**
         * �������� �������
         */
        ADD,
        /**
         * ������� �������
         */
        REMOVE
    }

    public void execute(O operation, ListModel<P> model,
                        Collection<Model<P>> attribute) {
        if (operation == null)
            throw new NullPointerException("������ �������� operation");
        if (model == null)
            throw new NullPointerException("������ �������� model");
        if (attribute == null)
            throw new NullPointerException("������ �������� attribute");
        switch (operation) {
            case ADD:
                for (final Model<P> _model : attribute)
                    model.add(_model);
                break;
            case REMOVE:
                for (final Model<P> _model : attribute)
                    model.remove(_model);
                break;
            default:
                throw new IllegalArgumentException("����������� ��������: " +
                        operation);
        }
    }

    @SuppressWarnings("unchecked")
    public void execute(O operation, ListModel<P> model, Model<P> attribute) {
        execute(operation, model, Arrays.asList(attribute));
    }
}