package com.yanxuan.test.dailyTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yyhu3
 * @Date 2018-05-15 16:11
 */
public class CustomList {

    int size;
    Object[] elementData;

    public CustomList()
    {
        this(3);
//        List test = new ArrayList();
//        test.add("132");
    }

    public CustomList(int initialization)
    {
        elementData = new Object[initialization];
    }

    public void add(Object obj)
    {
        if (size>=elementData.length)
        {
            Object[] elementDataNew = new Object[size+1];
            for (int temp=0;temp<elementData.length;temp++)
            {
                elementDataNew[temp] = elementData[temp];
            }
            elementData = elementDataNew;
            elementData[size] = obj;
        }
        else{
            elementData[size] = obj;
            size++;
        }
    }

    public Object get(int index)
    {
        if (index<0||index>=elementData.length)
        {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                return null;
            }
        }
        else
        {
            return elementData[index];
        }
    }

    public int length()
    {
        return elementData.length;
    }

    public boolean isEmpty()
    {
        return elementData.length ==0;
    }

    public void remove(Object obj)
    {
        for (int reTemp=0;reTemp<elementData.length;reTemp++)
        {
            if (elementData[reTemp].equals(obj))
            {
                for(int newTemp=reTemp+1;newTemp<elementData.length;newTemp++)
                {
                    elementData[newTemp] = elementData[newTemp--];
                    size--;
                }
//                elementData.
            }
        }
    }

    public static void main(String[] args)
    {
        CustomList customList = new CustomList();
        customList.add(12);
        customList.add("132456");
        customList.add(1);
        customList.add(2);

        for (int i =0;i<customList.length();i++)
        {
            System.out.println(customList.get(i));
        }
        customList.remove(1);
        for (int i =0;i<customList.length();i++)
        {
            System.out.println(customList.get(i));
        }
        System.out.println(customList.isEmpty());
    }
}
