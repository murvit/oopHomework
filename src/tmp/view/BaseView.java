package tmp.view;


import tmp.model.IModelSubscriber;
import tmp.model.Model;

/**
 * ������� �������������
 * @param <M> ������
 * @param <P> �������� ������
 */
public abstract class BaseView<M extends Model<P>, P> implements
        IModelSubscriber<P> {
    private M model;

    /**
     * �������� ������
     * @return ������
     */
    protected M getModel() {
        return model;
    }

    /**
     * ���������� ������
     * @param model ������
     */
    public void setModel(M model) {
        unsubscribe();
        this.model = model;
        subscribe();
    }

/*** ����������� �� ������� ������
 */
private void subscribe() {
    if (model != null)
        model.subscribe(this);
}

    /**
     * ����� �������� � ������
     */
    private void unsubscribe() {
        if (model != null)
            model.unsubscribe(this);
    }

    /**
     * ����������� ��������
     */
    public void dispose() {
        unsubscribe();
    }
}
