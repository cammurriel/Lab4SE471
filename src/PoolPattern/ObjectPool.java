package PoolPattern;

public class ObjectPool implements ObjectPool_IF {
    private Object lockObject = new Object();
    private int size;
    private int instanceCount;
    private int maxInstances;
    private Object [] pool;
    private static ObjectPool poolInstance;
    ObjectCreation_IF creator;

    ObjectPool()
    {
        size = 0;
        instanceCount = 0;
        maxInstances = 0;
        pool = null;
    }

    private ObjectPool(ObjectCreation_IF c, int max)
    {
        instanceCount=0;
        creator=c;
        this.maxInstances=max;
        pool = new Object[maxInstances];

    }
    //made getPoolInstance static
    public static ObjectPool getPoolInstance(ObjectCreation_IF c, int max) {
        if (poolInstance==null)
            poolInstance = new ObjectPool(c, max);
        return poolInstance;
    }
    public int getSize()
    {
        return size;
    }

    public int getInstanceCount() {
        return instanceCount;
    }

    public int getMaxInstances() {
        return maxInstances;
    }

    public int getCapacity() //fix later
    {

        return 0;
    }

    @Override
    public void setCapacity(int c) {

       if(c <= 0)
       {
           String msg = "Capacity must be greater than zero: " + c;
           throw new IllegalArgumentException(msg);
       }
       synchronized (lockObject)
       {
           Object[] newPool = new Object[c];
           System.arraycopy(pool,0,newPool,0,c);
           pool = newPool;
       }
    }

    public Object getObject() //fix
    {
        synchronized (lockObject)
        {
            if(size > 0)
            {
                return removeObject();
            }
            else if(getInstanceCount() < getMaxInstances())
            {
                return createObject();
            }
            else
            {
                return null;
            }
        }
    }


    @Override
    public void release(Object o) {
        if (o == null)
        {
            throw new NullPointerException();
        }
        synchronized (lockObject)
        {
            if(getSize() < getCapacity())
            {
                pool[size] = o;
                size++;
                lockObject.notify();
            }
        }
    }


    public Object waitForObject() throws InterruptedException {
        synchronized (lockObject)
        {
            if(size > 0)
            {
                return removeObject();
            }
            else if(getInstanceCount() < getMaxInstances())
            {
                return createObject();
            }
            else
            {
                do{
                    lockObject.wait();
                }
                while(size <= 0);
                return removeObject();
            }
        }
    }
    private Object removeObject()
    {
        size--;
        return pool[size];
    }

    private Object createObject() //fix
    {
       Object newObject = creator.create();
       instanceCount++;
       return newObject;
    }

}
