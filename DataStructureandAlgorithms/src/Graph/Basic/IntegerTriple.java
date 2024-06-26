package Graph.Basic;

public class IntegerTriple {

	private Integer weight;
	private Integer source;
	private Integer dest;

	public IntegerTriple(Integer w, Integer s, Integer d) {
		weight = w;
		source = s;
		dest = d;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getSource() {
		return source;
	}

	public Integer getDest() {
		return dest;
	}

	@Override
	public String toString() {
		return weight + " " + source + " " + dest;
	}
}
