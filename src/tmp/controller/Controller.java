package tmp.controller;

import tmp.model.Model;

/**
 * ����������
 * @param <P>
 * �������� ������
 */
public class Controller<P> implements IController<Controller.O, Model<P>, P> {
    /**
     * �������� ��� �������
     */
    public enum O {
        /**
         * �������������
         */
        EDIT
    }

    public void execute(O operation, Model<P> model, P attribute) {
        if (operation == null)
            throw new NullPointerException("������ �������� operation");
        if (model == null)
            throw new NullPointerException("������ �������� model");
        if (attribute == null)
            throw new NullPointerException("������ �������� attribute");
        switch (operation) {
            case EDIT:
                model.setProperty(attribute);
                break;
            default:
                throw new IllegalArgumentException("����������� ��������: " +
                        operation);
        }
    }
}