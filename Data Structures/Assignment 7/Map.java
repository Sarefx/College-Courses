
public class Map<KeyType,ValueType>
{
	private QuadraticProbingHashTable<Entry<KeyType, ValueType>> items;
	
	public Map()
	{ 
		items = new QuadraticProbingHashTable<>();
	}
	public void put(KeyType key, ValueType val)
	{
		Entry<KeyType, ValueType> temp = new Entry<>();
		temp.setKeyAndValue(key, val);
		items .insert(temp);
	}
	public ValueType get(KeyType key)
	{
		Entry<KeyType, ValueType> temp = new Entry<>();
		temp.setKey(key);
		temp = items.get(temp);
		return temp.getValue();
	}
	public boolean isEmpty()
	{
		if (items.size()==0)
			return true;
		else
			return false;
	}
	public void makeEmpty()
	{
		items.makeEmpty();
	}
	private static class Entry<KeyType, ValueType>
	{
		KeyType key;
		ValueType value;
		public void Entry()
		{
			key=null;
			value=null;
		}
		public void setKeyAndValue(KeyType key1, ValueType val1)
		{
			key=key1;
			value=val1;
		}
		public void setKey(KeyType key1)
		{
			key=key1;
		}
		public void setValue(ValueType val1)
		{
			value=val1;
		}
		public ValueType getValue()
		{
			return value;
		}
		public KeyType getKey()
		{
			return key;
		}
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			
			Entry other = (Entry) obj;
			
			if (other.getValue()== value)
				return true;
			else 
				return false;
		}
		public int hashCode()
		{
			return value.hashCode();
		}
	}
	
}
