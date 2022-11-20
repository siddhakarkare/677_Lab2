// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data_types.proto

package org.example.data_types;

/**
 * Protobuf type {@code TransactionRequest}
 */
public  final class TransactionRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:TransactionRequest)
    TransactionRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TransactionRequest.newBuilder() to construct.
  private TransactionRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TransactionRequest() {
    buyerId_ = 0;
    productName_ = "";
    qty_ = 0;
    clock_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TransactionRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            buyerId_ = input.readUInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            productName_ = s;
            break;
          }
          case 24: {

            qty_ = input.readUInt32();
            break;
          }
          case 32: {

            clock_ = input.readUInt64();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.example.data_types.DataTypes.internal_static_TransactionRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.example.data_types.DataTypes.internal_static_TransactionRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.example.data_types.TransactionRequest.class, org.example.data_types.TransactionRequest.Builder.class);
  }

  public static final int BUYER_ID_FIELD_NUMBER = 1;
  private int buyerId_;
  /**
   * <code>uint32 buyer_id = 1;</code>
   */
  public int getBuyerId() {
    return buyerId_;
  }

  public static final int PRODUCT_NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object productName_;
  /**
   * <code>string product_name = 2;</code>
   */
  public java.lang.String getProductName() {
    java.lang.Object ref = productName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      productName_ = s;
      return s;
    }
  }
  /**
   * <code>string product_name = 2;</code>
   */
  public com.google.protobuf.ByteString
      getProductNameBytes() {
    java.lang.Object ref = productName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      productName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QTY_FIELD_NUMBER = 3;
  private int qty_;
  /**
   * <code>uint32 qty = 3;</code>
   */
  public int getQty() {
    return qty_;
  }

  public static final int CLOCK_FIELD_NUMBER = 4;
  private long clock_;
  /**
   * <code>uint64 clock = 4;</code>
   */
  public long getClock() {
    return clock_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (buyerId_ != 0) {
      output.writeUInt32(1, buyerId_);
    }
    if (!getProductNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, productName_);
    }
    if (qty_ != 0) {
      output.writeUInt32(3, qty_);
    }
    if (clock_ != 0L) {
      output.writeUInt64(4, clock_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (buyerId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, buyerId_);
    }
    if (!getProductNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, productName_);
    }
    if (qty_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, qty_);
    }
    if (clock_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(4, clock_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.example.data_types.TransactionRequest)) {
      return super.equals(obj);
    }
    org.example.data_types.TransactionRequest other = (org.example.data_types.TransactionRequest) obj;

    boolean result = true;
    result = result && (getBuyerId()
        == other.getBuyerId());
    result = result && getProductName()
        .equals(other.getProductName());
    result = result && (getQty()
        == other.getQty());
    result = result && (getClock()
        == other.getClock());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + BUYER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getBuyerId();
    hash = (37 * hash) + PRODUCT_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getProductName().hashCode();
    hash = (37 * hash) + QTY_FIELD_NUMBER;
    hash = (53 * hash) + getQty();
    hash = (37 * hash) + CLOCK_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getClock());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.example.data_types.TransactionRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.data_types.TransactionRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.data_types.TransactionRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.data_types.TransactionRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.data_types.TransactionRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.data_types.TransactionRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.data_types.TransactionRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.data_types.TransactionRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.data_types.TransactionRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.example.data_types.TransactionRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.data_types.TransactionRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.data_types.TransactionRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.example.data_types.TransactionRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code TransactionRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:TransactionRequest)
      org.example.data_types.TransactionRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.example.data_types.DataTypes.internal_static_TransactionRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.example.data_types.DataTypes.internal_static_TransactionRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.example.data_types.TransactionRequest.class, org.example.data_types.TransactionRequest.Builder.class);
    }

    // Construct using org.example.data_types.TransactionRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      buyerId_ = 0;

      productName_ = "";

      qty_ = 0;

      clock_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.example.data_types.DataTypes.internal_static_TransactionRequest_descriptor;
    }

    @java.lang.Override
    public org.example.data_types.TransactionRequest getDefaultInstanceForType() {
      return org.example.data_types.TransactionRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.example.data_types.TransactionRequest build() {
      org.example.data_types.TransactionRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.example.data_types.TransactionRequest buildPartial() {
      org.example.data_types.TransactionRequest result = new org.example.data_types.TransactionRequest(this);
      result.buyerId_ = buyerId_;
      result.productName_ = productName_;
      result.qty_ = qty_;
      result.clock_ = clock_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.example.data_types.TransactionRequest) {
        return mergeFrom((org.example.data_types.TransactionRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.example.data_types.TransactionRequest other) {
      if (other == org.example.data_types.TransactionRequest.getDefaultInstance()) return this;
      if (other.getBuyerId() != 0) {
        setBuyerId(other.getBuyerId());
      }
      if (!other.getProductName().isEmpty()) {
        productName_ = other.productName_;
        onChanged();
      }
      if (other.getQty() != 0) {
        setQty(other.getQty());
      }
      if (other.getClock() != 0L) {
        setClock(other.getClock());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.example.data_types.TransactionRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.example.data_types.TransactionRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int buyerId_ ;
    /**
     * <code>uint32 buyer_id = 1;</code>
     */
    public int getBuyerId() {
      return buyerId_;
    }
    /**
     * <code>uint32 buyer_id = 1;</code>
     */
    public Builder setBuyerId(int value) {
      
      buyerId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 buyer_id = 1;</code>
     */
    public Builder clearBuyerId() {
      
      buyerId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object productName_ = "";
    /**
     * <code>string product_name = 2;</code>
     */
    public java.lang.String getProductName() {
      java.lang.Object ref = productName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        productName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string product_name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getProductNameBytes() {
      java.lang.Object ref = productName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        productName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string product_name = 2;</code>
     */
    public Builder setProductName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      productName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string product_name = 2;</code>
     */
    public Builder clearProductName() {
      
      productName_ = getDefaultInstance().getProductName();
      onChanged();
      return this;
    }
    /**
     * <code>string product_name = 2;</code>
     */
    public Builder setProductNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      productName_ = value;
      onChanged();
      return this;
    }

    private int qty_ ;
    /**
     * <code>uint32 qty = 3;</code>
     */
    public int getQty() {
      return qty_;
    }
    /**
     * <code>uint32 qty = 3;</code>
     */
    public Builder setQty(int value) {
      
      qty_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 qty = 3;</code>
     */
    public Builder clearQty() {
      
      qty_ = 0;
      onChanged();
      return this;
    }

    private long clock_ ;
    /**
     * <code>uint64 clock = 4;</code>
     */
    public long getClock() {
      return clock_;
    }
    /**
     * <code>uint64 clock = 4;</code>
     */
    public Builder setClock(long value) {
      
      clock_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 clock = 4;</code>
     */
    public Builder clearClock() {
      
      clock_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:TransactionRequest)
  }

  // @@protoc_insertion_point(class_scope:TransactionRequest)
  private static final org.example.data_types.TransactionRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.example.data_types.TransactionRequest();
  }

  public static org.example.data_types.TransactionRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TransactionRequest>
      PARSER = new com.google.protobuf.AbstractParser<TransactionRequest>() {
    @java.lang.Override
    public TransactionRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TransactionRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TransactionRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TransactionRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.example.data_types.TransactionRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

