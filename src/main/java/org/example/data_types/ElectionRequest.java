// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data_types.proto

package org.example.data_types;

/**
 * Protobuf type {@code ElectionRequest}
 */
public  final class ElectionRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ElectionRequest)
    ElectionRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ElectionRequest.newBuilder() to construct.
  private ElectionRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ElectionRequest() {
    contenderId_ = 0;
    contenderVoterId_ = 0;
    path_ = java.util.Collections.emptyList();
    isInitiator_ = false;
    clock_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ElectionRequest(
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

            contenderId_ = input.readUInt32();
            break;
          }
          case 16: {

            contenderVoterId_ = input.readUInt32();
            break;
          }
          case 24: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              path_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000004;
            }
            path_.add(input.readUInt32());
            break;
          }
          case 26: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004) && input.getBytesUntilLimit() > 0) {
              path_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000004;
            }
            while (input.getBytesUntilLimit() > 0) {
              path_.add(input.readUInt32());
            }
            input.popLimit(limit);
            break;
          }
          case 32: {

            isInitiator_ = input.readBool();
            break;
          }
          case 40: {

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
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        path_ = java.util.Collections.unmodifiableList(path_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.example.data_types.DataTypes.internal_static_ElectionRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.example.data_types.DataTypes.internal_static_ElectionRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.example.data_types.ElectionRequest.class, org.example.data_types.ElectionRequest.Builder.class);
  }

  private int bitField0_;
  public static final int CONTENDERID_FIELD_NUMBER = 1;
  private int contenderId_;
  /**
   * <code>uint32 contenderId = 1;</code>
   */
  public int getContenderId() {
    return contenderId_;
  }

  public static final int CONTENDERVOTERID_FIELD_NUMBER = 2;
  private int contenderVoterId_;
  /**
   * <code>uint32 contenderVoterId = 2;</code>
   */
  public int getContenderVoterId() {
    return contenderVoterId_;
  }

  public static final int PATH_FIELD_NUMBER = 3;
  private java.util.List<java.lang.Integer> path_;
  /**
   * <code>repeated uint32 path = 3;</code>
   */
  public java.util.List<java.lang.Integer>
      getPathList() {
    return path_;
  }
  /**
   * <code>repeated uint32 path = 3;</code>
   */
  public int getPathCount() {
    return path_.size();
  }
  /**
   * <code>repeated uint32 path = 3;</code>
   */
  public int getPath(int index) {
    return path_.get(index);
  }
  private int pathMemoizedSerializedSize = -1;

  public static final int ISINITIATOR_FIELD_NUMBER = 4;
  private boolean isInitiator_;
  /**
   * <code>bool isInitiator = 4;</code>
   */
  public boolean getIsInitiator() {
    return isInitiator_;
  }

  public static final int CLOCK_FIELD_NUMBER = 5;
  private long clock_;
  /**
   * <code>uint64 clock = 5;</code>
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
    getSerializedSize();
    if (contenderId_ != 0) {
      output.writeUInt32(1, contenderId_);
    }
    if (contenderVoterId_ != 0) {
      output.writeUInt32(2, contenderVoterId_);
    }
    if (getPathList().size() > 0) {
      output.writeUInt32NoTag(26);
      output.writeUInt32NoTag(pathMemoizedSerializedSize);
    }
    for (int i = 0; i < path_.size(); i++) {
      output.writeUInt32NoTag(path_.get(i));
    }
    if (isInitiator_ != false) {
      output.writeBool(4, isInitiator_);
    }
    if (clock_ != 0L) {
      output.writeUInt64(5, clock_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (contenderId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, contenderId_);
    }
    if (contenderVoterId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, contenderVoterId_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < path_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt32SizeNoTag(path_.get(i));
      }
      size += dataSize;
      if (!getPathList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      pathMemoizedSerializedSize = dataSize;
    }
    if (isInitiator_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, isInitiator_);
    }
    if (clock_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(5, clock_);
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
    if (!(obj instanceof org.example.data_types.ElectionRequest)) {
      return super.equals(obj);
    }
    org.example.data_types.ElectionRequest other = (org.example.data_types.ElectionRequest) obj;

    boolean result = true;
    result = result && (getContenderId()
        == other.getContenderId());
    result = result && (getContenderVoterId()
        == other.getContenderVoterId());
    result = result && getPathList()
        .equals(other.getPathList());
    result = result && (getIsInitiator()
        == other.getIsInitiator());
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
    hash = (37 * hash) + CONTENDERID_FIELD_NUMBER;
    hash = (53 * hash) + getContenderId();
    hash = (37 * hash) + CONTENDERVOTERID_FIELD_NUMBER;
    hash = (53 * hash) + getContenderVoterId();
    if (getPathCount() > 0) {
      hash = (37 * hash) + PATH_FIELD_NUMBER;
      hash = (53 * hash) + getPathList().hashCode();
    }
    hash = (37 * hash) + ISINITIATOR_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsInitiator());
    hash = (37 * hash) + CLOCK_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getClock());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.example.data_types.ElectionRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.data_types.ElectionRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.data_types.ElectionRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.data_types.ElectionRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.data_types.ElectionRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.data_types.ElectionRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.data_types.ElectionRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.data_types.ElectionRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.data_types.ElectionRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.example.data_types.ElectionRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.data_types.ElectionRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.data_types.ElectionRequest parseFrom(
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
  public static Builder newBuilder(org.example.data_types.ElectionRequest prototype) {
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
   * Protobuf type {@code ElectionRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ElectionRequest)
      org.example.data_types.ElectionRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.example.data_types.DataTypes.internal_static_ElectionRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.example.data_types.DataTypes.internal_static_ElectionRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.example.data_types.ElectionRequest.class, org.example.data_types.ElectionRequest.Builder.class);
    }

    // Construct using org.example.data_types.ElectionRequest.newBuilder()
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
      contenderId_ = 0;

      contenderVoterId_ = 0;

      path_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000004);
      isInitiator_ = false;

      clock_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.example.data_types.DataTypes.internal_static_ElectionRequest_descriptor;
    }

    @java.lang.Override
    public org.example.data_types.ElectionRequest getDefaultInstanceForType() {
      return org.example.data_types.ElectionRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.example.data_types.ElectionRequest build() {
      org.example.data_types.ElectionRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.example.data_types.ElectionRequest buildPartial() {
      org.example.data_types.ElectionRequest result = new org.example.data_types.ElectionRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.contenderId_ = contenderId_;
      result.contenderVoterId_ = contenderVoterId_;
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        path_ = java.util.Collections.unmodifiableList(path_);
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.path_ = path_;
      result.isInitiator_ = isInitiator_;
      result.clock_ = clock_;
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof org.example.data_types.ElectionRequest) {
        return mergeFrom((org.example.data_types.ElectionRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.example.data_types.ElectionRequest other) {
      if (other == org.example.data_types.ElectionRequest.getDefaultInstance()) return this;
      if (other.getContenderId() != 0) {
        setContenderId(other.getContenderId());
      }
      if (other.getContenderVoterId() != 0) {
        setContenderVoterId(other.getContenderVoterId());
      }
      if (!other.path_.isEmpty()) {
        if (path_.isEmpty()) {
          path_ = other.path_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensurePathIsMutable();
          path_.addAll(other.path_);
        }
        onChanged();
      }
      if (other.getIsInitiator() != false) {
        setIsInitiator(other.getIsInitiator());
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
      org.example.data_types.ElectionRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.example.data_types.ElectionRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int contenderId_ ;
    /**
     * <code>uint32 contenderId = 1;</code>
     */
    public int getContenderId() {
      return contenderId_;
    }
    /**
     * <code>uint32 contenderId = 1;</code>
     */
    public Builder setContenderId(int value) {
      
      contenderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 contenderId = 1;</code>
     */
    public Builder clearContenderId() {
      
      contenderId_ = 0;
      onChanged();
      return this;
    }

    private int contenderVoterId_ ;
    /**
     * <code>uint32 contenderVoterId = 2;</code>
     */
    public int getContenderVoterId() {
      return contenderVoterId_;
    }
    /**
     * <code>uint32 contenderVoterId = 2;</code>
     */
    public Builder setContenderVoterId(int value) {
      
      contenderVoterId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 contenderVoterId = 2;</code>
     */
    public Builder clearContenderVoterId() {
      
      contenderVoterId_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Integer> path_ = java.util.Collections.emptyList();
    private void ensurePathIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        path_ = new java.util.ArrayList<java.lang.Integer>(path_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <code>repeated uint32 path = 3;</code>
     */
    public java.util.List<java.lang.Integer>
        getPathList() {
      return java.util.Collections.unmodifiableList(path_);
    }
    /**
     * <code>repeated uint32 path = 3;</code>
     */
    public int getPathCount() {
      return path_.size();
    }
    /**
     * <code>repeated uint32 path = 3;</code>
     */
    public int getPath(int index) {
      return path_.get(index);
    }
    /**
     * <code>repeated uint32 path = 3;</code>
     */
    public Builder setPath(
        int index, int value) {
      ensurePathIsMutable();
      path_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint32 path = 3;</code>
     */
    public Builder addPath(int value) {
      ensurePathIsMutable();
      path_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint32 path = 3;</code>
     */
    public Builder addAllPath(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensurePathIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, path_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint32 path = 3;</code>
     */
    public Builder clearPath() {
      path_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }

    private boolean isInitiator_ ;
    /**
     * <code>bool isInitiator = 4;</code>
     */
    public boolean getIsInitiator() {
      return isInitiator_;
    }
    /**
     * <code>bool isInitiator = 4;</code>
     */
    public Builder setIsInitiator(boolean value) {
      
      isInitiator_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isInitiator = 4;</code>
     */
    public Builder clearIsInitiator() {
      
      isInitiator_ = false;
      onChanged();
      return this;
    }

    private long clock_ ;
    /**
     * <code>uint64 clock = 5;</code>
     */
    public long getClock() {
      return clock_;
    }
    /**
     * <code>uint64 clock = 5;</code>
     */
    public Builder setClock(long value) {
      
      clock_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 clock = 5;</code>
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


    // @@protoc_insertion_point(builder_scope:ElectionRequest)
  }

  // @@protoc_insertion_point(class_scope:ElectionRequest)
  private static final org.example.data_types.ElectionRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.example.data_types.ElectionRequest();
  }

  public static org.example.data_types.ElectionRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ElectionRequest>
      PARSER = new com.google.protobuf.AbstractParser<ElectionRequest>() {
    @java.lang.Override
    public ElectionRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ElectionRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ElectionRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ElectionRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.example.data_types.ElectionRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

