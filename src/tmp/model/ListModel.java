package tmp.model;


import java.util.Collection;
import java.util.HashSet;

/**
 * ������ ������
 * @param <P> �������� ������
 */
public class ListModel<P> extends Model<Collection<Model<P>>> implements
        IModelSubscriber<P> {
    /**
     * �����������
     */
    public ListModel() {
        super(new HashSet<Model<P>>());
    }

    /**
     * �������� ������
     * @param model ������
     */
    public void add(Model<P> model) {
        if (model == null)
            throw new NullPointerException("������ ��������");
        getProperty().add(model);
        model.subscribe(this);
    }

    @Override
    public void modelChanged(Model<P> model) {
        if (model == null)
            throw new NullPointerException("������ ��������");
        notifySubscribers();
    }

    /**
     * ������� ������
     * @param model ������
     */
    public void remove(Model<P> model) {
        if (model == null)
            throw new NullPointerException("������ ��������");
        model.unsubscribe(this);
        getProperty().remove(model);
        notifySubscribers();
    }
}