package tmp.model;


/**
 * ��������� ������
 * @param <P> �������� ������
 */
public interface IModelSubscriber<P> {
    /**
     * ������� ��������� ������
     * @param model ������
     */
    void modelChanged(Model<P> model);

}
