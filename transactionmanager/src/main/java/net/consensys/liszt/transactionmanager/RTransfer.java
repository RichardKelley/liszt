package net.consensys.liszt.transactionmanager;

import java.math.BigDecimal;
import net.consensys.liszt.core.crypto.PublicKey;
import net.consensys.liszt.core.crypto.Signature;

/**
 * Represents a transfer transaction for a rollup, as seen by a user. TODO: choose the rights types
 * for bytes (do as Pantheon)
 */
public class RTransfer {
  public final int nonce;
  public final PublicKey from;
  public final PublicKey to;
  public final BigDecimal amount;
  public final int rIdFrom;
  public final int rIdTo;
  public final Signature sig;

  public RTransfer(
      int nonce,
      PublicKey from,
      PublicKey to,
      BigDecimal amount,
      int rIdFrom,
      int rIdTo,
      Signature sig) {
    this.nonce = nonce;
    this.from = from;
    this.to = to;
    this.amount = amount;
    this.rIdFrom = rIdFrom;
    this.rIdTo = rIdTo;
    this.sig = sig;
  }

  public boolean isSigned() {
    return sig.validate(from, hash());
  }

  public byte[] hash() {
    return null;
  }
}
