package tmp.model;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ������
 * @param <P> �������� ������
 */
public class Model<P> {
    private P property;

    private final Collection<IModelSubscriber<P>> subscribers = new CopyOnWriteArrayList<IModelSubscriber<P>>();

    /**
     * �����������
     * @param property �������� ������
     */
    public Model(P property) {
        if (property == null)
            throw new NullPointerException("������ ��������");
        this.property = property;
    }

    /**
     * �������� �������� ������
     * @return �������� ������
     */
    public P getProperty() {
        return property;
    }

    /**
     * ���������� �������� ������
     * @param property �������� ������
     */
    public void setProperty(P property) {
        if (property == null)
            throw new NullPointerException("������ ��������");
        this.property = property;
        notifySubscribers();
    }

    /**
     * ���������� ���� �����������
     */
    protected void notifySubscribers() {
        for (final IModelSubscriber<P> subscriber : subscribers)
            notifySubscriber(subscriber);
    }

    /**
     * ���������� ����������
     * @param subscriber ��������� ������
     */
    private void notifySubscriber(IModelSubscriber<P> subscriber) {
        assert subscriber != null;
        subscriber.modelChanged(this);
    }

    /**
     * �����������
     * @param subscriber ��������� ������
     */
    public void subscribe(IModelSubscriber<P> subscriber) {
        if (subscriber == null)
            throw new NullPointerException("������ ��������");
        if (subscribers.contains(subscriber))
            throw new IllegalArgumentException("��������� ��������: " +
                    subscriber);
        subscribers.add(subscriber);
        notifySubscriber(subscriber);
    }

    /**
     * ����������
     * @param subscriber ��������� ������
     */
    public void unsubscribe(IModelSubscriber<P> subscriber) {
        if (subscriber == null)
            throw new NullPointerException("������ ��������");
        if (!subscribers.contains(subscriber))
            throw new IllegalArgumentException("����������� ���������: " +
                    subscriber);
        subscribers.remove(subscriber);
    }

    @Override
    public String toString() {
        return property.toString();
    }
}