package domain;

public enum Versus {
	WIN("승"),
	DRAW("무"),
	LOSE("패"),
	UNDEFINE("미정");

	private final String result;

	Versus(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}
}
