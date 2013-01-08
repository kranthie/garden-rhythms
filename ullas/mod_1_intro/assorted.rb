class Array
  def bubble_sort
    sorted = self.dup
    (sorted.length-1).downto(0) do
      |i|
      0.upto(i-1) do
        |j|
         if sorted[j] > sorted[j+1]
           sorted[j], sorted[j+1] = sorted[j+1], sorted[j]
         end
      end
    end
    sorted
  end

  def selection_sort
    sorted = self.dup
    0.upto(sorted.length-1) do
      |i|
      min = sorted[i]
      i.upto(sorted.length-1) do
        |j|
        if min > sorted[j]
          min, sorted[j] = sorted[j], min
        end
      end
      sorted[i] = min
    end
    sorted
  end

  def insertion_sort
    sorted = self.dup
    sorted.each_index do
      |i|
      i.downto(1) do
        |j|
        if sorted[j] < sorted[j-1]
          sorted[j], sorted[j-1] = sorted[j-1], sorted[j]
        end
      end
    end
    sorted
  end
  
  def merge_sort(array=self)
    return array if array.size == 1 or array.empty?
    left = merge_sort(array[0...array.size/2])
    right = merge_sort(array[array.size/2...array.size])
    merge(left, right)
  end
  def merge(left, right)
    l, r, sorted = left.dup, right.dup, []
    while not l.empty? and not r.empty? do
      if l[0] <= r[0]
        sorted << l.shift
      else
        sorted << r.shift
      end
    end
    sorted += l if not l.empty?
    sorted += r if not r.empty?
    sorted
  end

  def qsort(array=self)
    return array if array.size <= 1
    a = array.dup
    p =  rand(a.size)
    pivot = a[p]
    a.delete_at(p)
    left, right = Array.new, Array.new
    a.each do
      |x|
      if x <= pivot
        left << x
      else
        right << x
      end
    end
    qsort(left) + [pivot] + qsort(right)
  end
  
  # Helper functions for heap-sort
  def parent(i)
    i/2
  end
  def left(i)
    i==0? 1 : (2*i - 1)
  end
  def right(i)
    i==0? 2 : 2*i
  end
  def max_heapify!(i)
    l, r = left(i), right(i)
    largest = (l <= (self.size-1) && self[l] > self[i])? l : i
    largest = r if r <= (self.size-1) && self[r] > self[largest]
    if largest != i
      self[i], self[largest] = self[largest], self[i]
      max_heapify!(largest)
    end
    self
  end
  def build_max_heap!()
    ((self.size-1)/2).downto 0 do
      |i|
      max_heapify!(i)
    end
    self
  end
  def heapsort!()
    self.build_max_heap!
  end
end

puts [1,2,3,4].max_heapify!(0)


