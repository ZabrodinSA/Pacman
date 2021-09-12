// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/pacman/protobuf/message.proto

package com.pacman.protobuf;

/**
 * Protobuf type {@code com.pacman.protobuf.Message}
 */
public final class Message extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.pacman.protobuf.Message)
    MessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Message.newBuilder() to construct.
  private Message(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Message() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Message();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Message(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
          case 10: {
            com.pacman.protobuf.Map.Builder subBuilder = null;
            if (map_ != null) {
              subBuilder = map_.toBuilder();
            }
            map_ = input.readMessage(com.pacman.protobuf.Map.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(map_);
              map_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.pacman.protobuf.Players.Builder subBuilder = null;
            if (players_ != null) {
              subBuilder = players_.toBuilder();
            }
            players_ = input.readMessage(com.pacman.protobuf.Players.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(players_);
              players_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
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
    return com.pacman.protobuf.MessageOuterClass.internal_static_com_pacman_protobuf_Message_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.pacman.protobuf.MessageOuterClass.internal_static_com_pacman_protobuf_Message_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.pacman.protobuf.Message.class, com.pacman.protobuf.Message.Builder.class);
  }

  public static final int MAP_FIELD_NUMBER = 1;
  private com.pacman.protobuf.Map map_;
  /**
   * <code>.com.pacman.protobuf.Map map = 1;</code>
   * @return Whether the map field is set.
   */
  @java.lang.Override
  public boolean hasMap() {
    return map_ != null;
  }
  /**
   * <code>.com.pacman.protobuf.Map map = 1;</code>
   * @return The map.
   */
  @java.lang.Override
  public com.pacman.protobuf.Map getMap() {
    return map_ == null ? com.pacman.protobuf.Map.getDefaultInstance() : map_;
  }
  /**
   * <code>.com.pacman.protobuf.Map map = 1;</code>
   */
  @java.lang.Override
  public com.pacman.protobuf.MapOrBuilder getMapOrBuilder() {
    return getMap();
  }

  public static final int PLAYERS_FIELD_NUMBER = 2;
  private com.pacman.protobuf.Players players_;
  /**
   * <code>.com.pacman.protobuf.Players players = 2;</code>
   * @return Whether the players field is set.
   */
  @java.lang.Override
  public boolean hasPlayers() {
    return players_ != null;
  }
  /**
   * <code>.com.pacman.protobuf.Players players = 2;</code>
   * @return The players.
   */
  @java.lang.Override
  public com.pacman.protobuf.Players getPlayers() {
    return players_ == null ? com.pacman.protobuf.Players.getDefaultInstance() : players_;
  }
  /**
   * <code>.com.pacman.protobuf.Players players = 2;</code>
   */
  @java.lang.Override
  public com.pacman.protobuf.PlayersOrBuilder getPlayersOrBuilder() {
    return getPlayers();
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
    if (map_ != null) {
      output.writeMessage(1, getMap());
    }
    if (players_ != null) {
      output.writeMessage(2, getPlayers());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (map_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getMap());
    }
    if (players_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getPlayers());
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
    if (!(obj instanceof com.pacman.protobuf.Message)) {
      return super.equals(obj);
    }
    com.pacman.protobuf.Message other = (com.pacman.protobuf.Message) obj;

    if (hasMap() != other.hasMap()) return false;
    if (hasMap()) {
      if (!getMap()
          .equals(other.getMap())) return false;
    }
    if (hasPlayers() != other.hasPlayers()) return false;
    if (hasPlayers()) {
      if (!getPlayers()
          .equals(other.getPlayers())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasMap()) {
      hash = (37 * hash) + MAP_FIELD_NUMBER;
      hash = (53 * hash) + getMap().hashCode();
    }
    if (hasPlayers()) {
      hash = (37 * hash) + PLAYERS_FIELD_NUMBER;
      hash = (53 * hash) + getPlayers().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.pacman.protobuf.Message parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pacman.protobuf.Message parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pacman.protobuf.Message parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pacman.protobuf.Message parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pacman.protobuf.Message parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pacman.protobuf.Message parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pacman.protobuf.Message parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.pacman.protobuf.Message parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.pacman.protobuf.Message parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.pacman.protobuf.Message parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.pacman.protobuf.Message parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.pacman.protobuf.Message parseFrom(
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
  public static Builder newBuilder(com.pacman.protobuf.Message prototype) {
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
   * Protobuf type {@code com.pacman.protobuf.Message}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.pacman.protobuf.Message)
      com.pacman.protobuf.MessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.pacman.protobuf.MessageOuterClass.internal_static_com_pacman_protobuf_Message_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.pacman.protobuf.MessageOuterClass.internal_static_com_pacman_protobuf_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.pacman.protobuf.Message.class, com.pacman.protobuf.Message.Builder.class);
    }

    // Construct using com.pacman.protobuf.Message.newBuilder()
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
      if (mapBuilder_ == null) {
        map_ = null;
      } else {
        map_ = null;
        mapBuilder_ = null;
      }
      if (playersBuilder_ == null) {
        players_ = null;
      } else {
        players_ = null;
        playersBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.pacman.protobuf.MessageOuterClass.internal_static_com_pacman_protobuf_Message_descriptor;
    }

    @java.lang.Override
    public com.pacman.protobuf.Message getDefaultInstanceForType() {
      return com.pacman.protobuf.Message.getDefaultInstance();
    }

    @java.lang.Override
    public com.pacman.protobuf.Message build() {
      com.pacman.protobuf.Message result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.pacman.protobuf.Message buildPartial() {
      com.pacman.protobuf.Message result = new com.pacman.protobuf.Message(this);
      if (mapBuilder_ == null) {
        result.map_ = map_;
      } else {
        result.map_ = mapBuilder_.build();
      }
      if (playersBuilder_ == null) {
        result.players_ = players_;
      } else {
        result.players_ = playersBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.pacman.protobuf.Message) {
        return mergeFrom((com.pacman.protobuf.Message)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.pacman.protobuf.Message other) {
      if (other == com.pacman.protobuf.Message.getDefaultInstance()) return this;
      if (other.hasMap()) {
        mergeMap(other.getMap());
      }
      if (other.hasPlayers()) {
        mergePlayers(other.getPlayers());
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
      com.pacman.protobuf.Message parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.pacman.protobuf.Message) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.pacman.protobuf.Map map_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.pacman.protobuf.Map, com.pacman.protobuf.Map.Builder, com.pacman.protobuf.MapOrBuilder> mapBuilder_;
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     * @return Whether the map field is set.
     */
    public boolean hasMap() {
      return mapBuilder_ != null || map_ != null;
    }
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     * @return The map.
     */
    public com.pacman.protobuf.Map getMap() {
      if (mapBuilder_ == null) {
        return map_ == null ? com.pacman.protobuf.Map.getDefaultInstance() : map_;
      } else {
        return mapBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     */
    public Builder setMap(com.pacman.protobuf.Map value) {
      if (mapBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        map_ = value;
        onChanged();
      } else {
        mapBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     */
    public Builder setMap(
        com.pacman.protobuf.Map.Builder builderForValue) {
      if (mapBuilder_ == null) {
        map_ = builderForValue.build();
        onChanged();
      } else {
        mapBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     */
    public Builder mergeMap(com.pacman.protobuf.Map value) {
      if (mapBuilder_ == null) {
        if (map_ != null) {
          map_ =
            com.pacman.protobuf.Map.newBuilder(map_).mergeFrom(value).buildPartial();
        } else {
          map_ = value;
        }
        onChanged();
      } else {
        mapBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     */
    public Builder clearMap() {
      if (mapBuilder_ == null) {
        map_ = null;
        onChanged();
      } else {
        map_ = null;
        mapBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     */
    public com.pacman.protobuf.Map.Builder getMapBuilder() {
      
      onChanged();
      return getMapFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     */
    public com.pacman.protobuf.MapOrBuilder getMapOrBuilder() {
      if (mapBuilder_ != null) {
        return mapBuilder_.getMessageOrBuilder();
      } else {
        return map_ == null ?
            com.pacman.protobuf.Map.getDefaultInstance() : map_;
      }
    }
    /**
     * <code>.com.pacman.protobuf.Map map = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.pacman.protobuf.Map, com.pacman.protobuf.Map.Builder, com.pacman.protobuf.MapOrBuilder> 
        getMapFieldBuilder() {
      if (mapBuilder_ == null) {
        mapBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.pacman.protobuf.Map, com.pacman.protobuf.Map.Builder, com.pacman.protobuf.MapOrBuilder>(
                getMap(),
                getParentForChildren(),
                isClean());
        map_ = null;
      }
      return mapBuilder_;
    }

    private com.pacman.protobuf.Players players_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.pacman.protobuf.Players, com.pacman.protobuf.Players.Builder, com.pacman.protobuf.PlayersOrBuilder> playersBuilder_;
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     * @return Whether the players field is set.
     */
    public boolean hasPlayers() {
      return playersBuilder_ != null || players_ != null;
    }
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     * @return The players.
     */
    public com.pacman.protobuf.Players getPlayers() {
      if (playersBuilder_ == null) {
        return players_ == null ? com.pacman.protobuf.Players.getDefaultInstance() : players_;
      } else {
        return playersBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     */
    public Builder setPlayers(com.pacman.protobuf.Players value) {
      if (playersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        players_ = value;
        onChanged();
      } else {
        playersBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     */
    public Builder setPlayers(
        com.pacman.protobuf.Players.Builder builderForValue) {
      if (playersBuilder_ == null) {
        players_ = builderForValue.build();
        onChanged();
      } else {
        playersBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     */
    public Builder mergePlayers(com.pacman.protobuf.Players value) {
      if (playersBuilder_ == null) {
        if (players_ != null) {
          players_ =
            com.pacman.protobuf.Players.newBuilder(players_).mergeFrom(value).buildPartial();
        } else {
          players_ = value;
        }
        onChanged();
      } else {
        playersBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     */
    public Builder clearPlayers() {
      if (playersBuilder_ == null) {
        players_ = null;
        onChanged();
      } else {
        players_ = null;
        playersBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     */
    public com.pacman.protobuf.Players.Builder getPlayersBuilder() {
      
      onChanged();
      return getPlayersFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     */
    public com.pacman.protobuf.PlayersOrBuilder getPlayersOrBuilder() {
      if (playersBuilder_ != null) {
        return playersBuilder_.getMessageOrBuilder();
      } else {
        return players_ == null ?
            com.pacman.protobuf.Players.getDefaultInstance() : players_;
      }
    }
    /**
     * <code>.com.pacman.protobuf.Players players = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.pacman.protobuf.Players, com.pacman.protobuf.Players.Builder, com.pacman.protobuf.PlayersOrBuilder> 
        getPlayersFieldBuilder() {
      if (playersBuilder_ == null) {
        playersBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.pacman.protobuf.Players, com.pacman.protobuf.Players.Builder, com.pacman.protobuf.PlayersOrBuilder>(
                getPlayers(),
                getParentForChildren(),
                isClean());
        players_ = null;
      }
      return playersBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.pacman.protobuf.Message)
  }

  // @@protoc_insertion_point(class_scope:com.pacman.protobuf.Message)
  private static final com.pacman.protobuf.Message DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.pacman.protobuf.Message();
  }

  public static com.pacman.protobuf.Message getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Message>
      PARSER = new com.google.protobuf.AbstractParser<Message>() {
    @java.lang.Override
    public Message parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Message(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Message> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Message> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.pacman.protobuf.Message getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

