package com.mycompany.myapp.error.domain;

public class StringTooLongException extends AssertionException {

  private StringTooLongException(StringTooLongExceptionBuilder builder) {
    super(builder.message());
  }

  public static StringTooLongExceptionBuilder builder() {
    return new StringTooLongExceptionBuilder();
  }

  static class StringTooLongExceptionBuilder {

    private String value;
    private int maxLength;
    private String field;

    private StringTooLongExceptionBuilder() {}

    StringTooLongExceptionBuilder field(String field) {
      this.field = field;

      return this;
    }

    StringTooLongExceptionBuilder value(String value) {
      this.value = value;

      return this;
    }

    StringTooLongExceptionBuilder maxLength(int maxLength) {
      this.maxLength = maxLength;

      return this;
    }

    private String message() {
      return new StringBuilder()
        .append("The value in field \"")
        .append(field)
        .append("\" must be at most ")
        .append(maxLength)
        .append(" long but was ")
        .append(value.length())
        .toString();
    }

    public StringTooLongException build() {
      return new StringTooLongException(this);
    }
  }
}
