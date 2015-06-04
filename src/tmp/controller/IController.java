package tmp.controller;

import tmp.model.Model;

/**
 * ����������� ����������
 * @param <O> ��������
 * @param <M> ������
 * @param <P> �������� ������
 */
public interface IController<O, M extends Model<P>, P> {
    /**
     * ���������
     * @param operation ��������
     * @param model ������
     * @param attribute ������� ��������
     */
    void execute(O operation, M model, P attribute);
}