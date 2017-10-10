/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package demo;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Location extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8704691122677163944L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Location\",\"namespace\":\"demo\",\"fields\":[{\"name\":\"created\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"id\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence created;
  @Deprecated public java.lang.CharSequence id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Location() {}

  /**
   * All-args constructor.
   * @param created The new value for created
   * @param id The new value for id
   */
  public Location(java.lang.CharSequence created, java.lang.CharSequence id) {
    this.created = created;
    this.id = id;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return created;
    case 1: return id;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: created = (java.lang.CharSequence)value$; break;
    case 1: id = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'created' field.
   * @return The value of the 'created' field.
   */
  public java.lang.CharSequence getCreated() {
    return created;
  }

  /**
   * Sets the value of the 'created' field.
   * @param value the value to set.
   */
  public void setCreated(java.lang.CharSequence value) {
    this.created = value;
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Creates a new Location RecordBuilder.
   * @return A new Location RecordBuilder
   */
  public static demo.Location.Builder newBuilder() {
    return new demo.Location.Builder();
  }

  /**
   * Creates a new Location RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Location RecordBuilder
   */
  public static demo.Location.Builder newBuilder(demo.Location.Builder other) {
    return new demo.Location.Builder(other);
  }

  /**
   * Creates a new Location RecordBuilder by copying an existing Location instance.
   * @param other The existing instance to copy.
   * @return A new Location RecordBuilder
   */
  public static demo.Location.Builder newBuilder(demo.Location other) {
    return new demo.Location.Builder(other);
  }

  /**
   * RecordBuilder for Location instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Location>
    implements org.apache.avro.data.RecordBuilder<Location> {

    private java.lang.CharSequence created;
    private java.lang.CharSequence id;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(demo.Location.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.created)) {
        this.created = data().deepCopy(fields()[0].schema(), other.created);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Location instance
     * @param other The existing instance to copy.
     */
    private Builder(demo.Location other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.created)) {
        this.created = data().deepCopy(fields()[0].schema(), other.created);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'created' field.
      * @return The value.
      */
    public java.lang.CharSequence getCreated() {
      return created;
    }

    /**
      * Sets the value of the 'created' field.
      * @param value The value of 'created'.
      * @return This builder.
      */
    public demo.Location.Builder setCreated(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.created = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'created' field has been set.
      * @return True if the 'created' field has been set, false otherwise.
      */
    public boolean hasCreated() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'created' field.
      * @return This builder.
      */
    public demo.Location.Builder clearCreated() {
      created = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public demo.Location.Builder setId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public demo.Location.Builder clearId() {
      id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Location build() {
      try {
        Location record = new Location();
        record.created = fieldSetFlags()[0] ? this.created : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.id = fieldSetFlags()[1] ? this.id : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}