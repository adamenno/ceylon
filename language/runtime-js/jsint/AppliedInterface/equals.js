function(o) {
  var eq=is$(o,{t:AppliedInterface$jsint}) && (o.tipo$2||o.tipo)==this.tipo;
  if (this.$bound)eq=eq && o.$bound && o.$bound.equals(this.$bound);else eq=eq && o.$bound===undefined;
  return eq && this.typeArguments.equals(o.typeArguments);
}
